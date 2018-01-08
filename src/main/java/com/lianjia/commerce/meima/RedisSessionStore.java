package com.lianjia.commerce.meima;

import org.pac4j.core.context.J2EContext;
import org.pac4j.core.context.session.SessionStore;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @author yangxiaochen
 * Date: 2018-01-08
 */
public class RedisSessionStore implements SessionStore<J2EContext> {

    JedisPool jedisPool;

    public RedisSessionStore() {
        this.jedisPool = new JedisPool("127.0.0.1");
    }

    @Override
    public String getOrCreateSessionId(J2EContext context) {

        return context.getRequest().getSession().getId();
    }

    @Override
    public Object get(J2EContext context, String key) {
        try (Jedis jedis = jedisPool.getResource()) {
            String sessionKey = jedis.get(context.getRequest().getSession().getId());
            return sessionKey;
        }
    }

    @Override
    public void set(J2EContext context, String key, Object value) {
        try (Jedis jedis = jedisPool.getResource()) {
            jedis.setex(key, 3600, value.toString());
        }
    }

    @Override
    public boolean destroySession(J2EContext context) {
        try (Jedis jedis = jedisPool.getResource()) {
            String sessionKey = jedis.get(context.getRequest().getSession().getId());
            jedis.del(sessionKey);
            return true;
        }
    }

    @Override
    public Object getTrackableSession(J2EContext context) {
        return null;
    }

    @Override
    public SessionStore<J2EContext> buildFromTrackableSession(J2EContext context, Object trackableSession) {
        return null;
    }

    @Override
    public boolean renewSession(J2EContext context) {
        return false;
    }
}
