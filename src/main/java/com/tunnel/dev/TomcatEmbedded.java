package com.tunnel.dev;

import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Development Code that binds the dataSource as JNDI.
 * This class & related jars in bootLibs will be excluded from war file
 *
 * @author Wayne Cao
 */
@Configuration
public class TomcatEmbedded {

    @Bean
    public TomcatEmbeddedServletContainerFactory tomcatFactory() {
        return new TomcatEmbeddedServletContainerFactory() {

            @Override
            protected TomcatEmbeddedServletContainer getTomcatEmbeddedServletContainer(Tomcat tomcat) {
                tomcat.enableNaming();
                return super.getTomcatEmbeddedServletContainer(tomcat);
            }

            @Override
            protected void postProcessContext(Context context) {

              /*  ContextResource resource = new ContextResource();
                resource.setName("jdbc/usermgmt");
                resource.setType(DataSource.class.getName());
                resource.setProperty("factory", "org.apache.commons.dbcp2.BasicDataSourceFactory");


                if (System.getProperty("enable_hsql") != null) {

                    resource.setProperty("driverClassName", "org.hsqldb.jdbcDriver");
                    resource.setProperty("url", "jdbc:hsqldb:mem:usermgmt;hsqldb.sql.ignore_case=true;sql.ignore_case=true");
                    resource.setProperty("username", "sa");
                    resource.setProperty("password", "");
                    EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
                    EmbeddedDatabase db = builder
                            .setName("usermgmt")
                            .setType(EmbeddedDatabaseType.HSQL).build();

                    try {
                        Statement stmt = db.getConnection().createStatement();
                        stmt.execute("SET DATABASE COLLATION SQL_TEXT_UCC");
                        stmt.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }


                } else {
                    resource.setProperty("driverClassName", "com.mysql.jdbc.Driver");
                    resource.setProperty("url", "jdbc:mysql://localhost:3306/user_mgmt_c360");
                    resource.setProperty("username", "userId");
                    resource.setProperty("password", "userId");
                }
                context.getNamingResources().addResource(resource);

*/

                /**/

                /*<Resource name="jdbc/usermgmt"
                auth="Container"
                factory="org.apache.commons.dbcp2.BasicDataSourceFactory"
                driverClassName="com.microsoft.sqlserver.jdbc.SQLServerDriver"
                type="javax.sql.DataSource"
                maxActive="50"
                maxIdle="10"
                maxWait="15000"
                username="aaum_owner"
                password="UserMgmtDbOwner@123"
                url="jdbc:sqlserver://strw099039.mso.net:1433;databaseName=AnalyticAppsUserManagement;"
                removeAbandoned="true"
                removeAbandonedTimeout="30"
                logAbandoned="true" />*/

                /*resource.setName("jdbc/usermgmt");
                resource.setType(DataSource.class.getName());
                resource.setProperty("factory", "org.apache.commons.dbcp2.BasicDataSourceFactory");
                resource.setProperty("driverClassName", "com.microsoft.sqlserver.jdbc.SQLServerDriver");
                resource.setProperty("url", "jdbc:sqlserver://strw099039.mso.net:1433;databaseName=AnalyticAppsUserManagement");
                resource.setProperty("username", "aaum_owner");
                resource.setProperty("password", "UserMgmtDbOwner@123");
                context.getNamingResources().addResource(resource);*/

            }
        };
    }

    /*@Bean(destroyMethod = "")
    public DataSource jndiDataSource() throws IllegalArgumentException, NamingException {
        JndiObjectFactoryBean bean = new JndiObjectFactoryBean();
        bean.setJndiName("java:comp/env/jdbc/usermgmt");
        bean.setProxyInterface(DataSource.class);
        bean.setLookupOnStartup(false);
        bean.afterPropertiesSet();
        return (DataSource) bean.getObject();
    }*/
}