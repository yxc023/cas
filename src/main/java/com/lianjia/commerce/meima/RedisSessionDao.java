package com.lianjia.commerce.meima;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.eis.AbstractSessionDAO;
import redis.clients.jedis.JedisPool;

import java.io.Serializable;
import java.util.Collection;

/**
 * @author yangxiaochen
 * Date: 2018-01-08
 */
public class RedisSessionDao extends AbstractSessionDAO {

    JedisPool jedisPool;
    ObjectMapper objectMapper = new ObjectMapper();

    public RedisSessionDao() {
        this.jedisPool = new JedisPool("127.0.0.1");
    }

    @Override
    protected Serializable doCreate(Session session) {
        Jedis
        return null;
    }

    @Override
    protected Session doReadSession(Serializable sessionId) {
        return null;
    }

    @Override
    public void update(Session session) throws UnknownSessionException {

    }

    @Override
    public void delete(Session session) {

    }

    @Override
    public Collection<Session> getActiveSessions() {
        return null;
    }
}
