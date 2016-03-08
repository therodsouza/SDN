package com.rodes.spring;

import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.data.neo4j.config.Neo4jConfiguration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.server.Neo4jServer;
import org.springframework.data.neo4j.server.RemoteServer;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableNeo4jRepositories(basePackages = "com.rodes.repository")
@EnableTransactionManagement
public class MyNeo4JConfiguration extends Neo4jConfiguration {

	@Bean
	@Override
	public Neo4jServer neo4jServer() {
		return new RemoteServer("http://localhost:7474", "neo4j", "alice");
	}
	
	@Bean
	@Override
	public SessionFactory getSessionFactory() {
		return new SessionFactory("com.rodes.domain");
	}
	
	@Bean
	@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
	public Session getSession() throws Exception {
		return super.getSession();
	}

}
