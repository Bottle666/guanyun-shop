package com.guanyun.shop.provider.util;

import cn.hutool.core.date.DateUtil;
import cn.hutool.crypto.SecureUtil;
import com.guanyun.shop.bean.enumeration.ErrorCode;
import com.guanyun.shop.bean.enumeration.Source;
import com.guanyun.shop.bean.response.Payload;
import com.guanyun.shop.provider.config.ConfigProperties;
import com.guanyun.shop.provider.config.FlowException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

@Slf4j
@Component
public class JwtUtils implements InitializingBean {

    private Key key;

    @Autowired
    private ConfigProperties configProperties;

    @Override
    public void afterPropertiesSet() throws Exception {
        key = new SecretKeySpec(configProperties.getJwt().getKey().getBytes(StandardCharsets.UTF_8), SignatureAlgorithm.HS256.getJcaName());
    }

    public static void main(String[] args) {
        System.out.println(SecureUtil.md5("123456"));
    }

    /**
     * 生成token
     */
    public String genToken(Payload payload){
        Date expiredDate = DateUtil.offsetMinute(new Date(), configProperties.getJwt().getAppExpired());
        if(Source.web.equals(payload.getSource())){
            expiredDate = DateUtil.offsetMinute(new Date(), configProperties.getJwt().getWebExpired());
        }

        return Jwts.builder()
                .setId(payload.getId() + "")
                .setExpiration(expiredDate)
                .claim("source", payload.getSource())
                .claim("timestamp", payload.getTimestamp())
                .signWith(SignatureAlgorithm.HS256, key).compact();
    }

    /**
     * 解析token
     */
    public Payload parser(String token) throws FlowException {
        if(StringUtils.isEmpty(token)){
            throw new FlowException("请先登录", ErrorCode.unauthorized);
        }

        try {
            Claims body = Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();

            Payload payload = new Payload();
            payload.setId(Integer.valueOf(body.getId()));
            payload.setSource(Source.valueOf(body.get("source").toString()));
            payload.setTimestamp(body.get("timestamp", Long.class));
            return payload;
        } catch (Exception e) {
            log.error("解析token异常", e);
            throw new FlowException("请先登录", ErrorCode.unauthorized);
        }
    }
}
