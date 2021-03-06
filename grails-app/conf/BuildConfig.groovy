grails.servlet.version = "2.5" // Change depending on target container compliance (2.5 or 3.0)
grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
grails.project.target.level = 1.6
grails.project.source.level = 1.6
//grails.project.war.file = "target/${appName}-${appVersion}.war"
grails.project.work.dir = "target"

grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits("global") {
        // uncomment to disable ehcache
        // excludes 'ehcache'
    }
    log "warn" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    checksums true // Whether to verify checksums on resolve
	
	def gebVersion = "0.7.0"
	def seleniumVersion = "2.21.0"
	
	repositories {
		grailsPlugins()
		grailsHome()
		grailsCentral()
		mavenLocal()
		mavenCentral()
		
		// For Geb snapshot
		mavenRepo "https://nexus.codehaus.org/content/repositories/snapshots"
	}
	dependencies {
		test("org.seleniumhq.selenium:selenium-htmlunit-driver:$seleniumVersion") {
			exclude "xml-apis"
		}
		test("org.seleniumhq.selenium:selenium-chrome-driver:$seleniumVersion")
		test("org.seleniumhq.selenium:selenium-firefox-driver:$seleniumVersion")

		// You usually only need one of these, but this project uses both
		test "org.codehaus.geb:geb-spock:$gebVersion"
		test "org.codehaus.geb:geb-junit4:$gebVersion"
	}
	plugins {
        runtime ":hibernate:$grailsVersion"
        runtime ":jquery:1.7.1"
        runtime ":resources:1.1.6"

        build ":tomcat:$grailsVersion"
		
		test ":geb:0.6.3"
		test ":spock:0.6"

        // Uncomment these (or add new ones) to enable additional resources capabilities
        //runtime ":zipped-resources:1.0"
        //runtime ":cached-resources:1.0"
        //runtime ":yui-minify-resources:0.1.4"
	}
}