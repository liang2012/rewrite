Rewrite:
=================================================

A highly configurable URL-rewriting tool for Java EE 6+ and Servlet 3.0 applications, supporting integration with:

 * CDI
 * Spring DI
 * JodaTime configuration
 * Tuckey.org URLRewriteFilter configuration
 * JavaServer Faces (JSF)
 * JavaServer Pages (JSP)
 * Struts
 * Wicket
 * Grails
 * Spring Roo
 * Spring Web Flow
 * Any servlet & web framework!

Get Help
==========
Support forum: http://ocpsoft.com/support/forum/rewrite

Get Started
==========

1. It is recommended but not required to remove other URL-rewriting tools from your application before using Rewrite. If you choose to leave them in place, weird things may happen, be warned.

2. Include OCPSoft Rewrite in your application's POM file:

        <dependency>
           <groupId>org.ocpsoft.rewrite</groupId>
           <artifactId>rewrite-impl-servlet</artifactId>
           <version>${rewrite.version}</version>
        </dependency>

3. Add a configuration provider implementing the 'org.ocpsoft.rewrite.config.ConfigurationProvider' interface, or extending from the abstract HttpConfigurationProvider class for convenience:

        package com.example;
        public class ExampleConfigurationProvider extends HttpConfigurationProvider
        {
	    
           @Override
           public int priority()
           {
             return 10;
           }
    
           @Override
           public Configuration getConfiguration(final ServletContext context)
           {
             return ConfigurationBuilder.begin()
               .defineRule()
                 .when(Direction.isInbound().and(Path.matches("/some/page/{p}/")))
                 .perform(Forward.to("/new-page/{p}.html"));
            }
        }

4. Create a file named: '/META-INF/services/org.ocpsoft.rewrite.config.ConfigurationProvider' which contains the fully qualified name of your ConfigurationProvider implementation:

        /META-INF/services/org.ocpsoft.rewrite.config.ConfigurationProvider
        ---
        com.example.ExampleConfigurationProvider

5. Add rules to your configuration. Condition objects such as 'Direction.isInbound()' and 'Path.matches(...)' can be found in the 'org.ocpsoft.rewrite.config.*' and 'org.ocpsoft.rewrite.servlet.config.*' packages.

6. Consider using Rewrite extensions for extra power:
   * [JodaTime Integration](https://github.com/ocpsoft/rewrite/tree/master/config-jodatime)
   * [Tuckey URLRewriteFilter Integration](https://github.com/ocpsoft/rewrite/tree/master/config-tuckey)
   * [CDI Integration](https://github.com/ocpsoft/rewrite/tree/master/integration-cdi)
   * And more...

7. Run your application!

FEEDBACK
========

This project is looking for your feedback! What would make your task easier? How can we simplify this experience?

TODO's
======

 * Continue simplification of Configuration objects and convenience APIs. 
 
 * Implement file test conditions.

 * Implement additional file-based configuration support.

 * Implement http://localhost:8080/rewrite-status monitoring tool
