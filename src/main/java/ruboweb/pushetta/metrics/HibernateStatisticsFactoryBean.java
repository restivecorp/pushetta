package ruboweb.pushetta.metrics;

import javax.persistence.EntityManagerFactory;

import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernateEntityManagerFactory;
import org.hibernate.stat.Statistics;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HibernateStatisticsFactoryBean implements FactoryBean<Statistics> {

	@Autowired
	private EntityManagerFactory entityManagerFactory;

	@Override
	public Statistics getObject() throws Exception {
		SessionFactory sessionFactory = ((HibernateEntityManagerFactory) entityManagerFactory)
				.getSessionFactory();
		return sessionFactory.getStatistics();
	}

	@Override
	public Class<?> getObjectType() {
		return Statistics.class;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}
}
