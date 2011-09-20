package delicious

import org.codehaus.groovy.grails.commons.ConfigurationHolder
import org.ig.grails.plugin.delecious.DeliciousPost

class TestController {

    def deliciousService

    def index = {

        def r = deliciousService.postNewBookmark(new DeliciousPost(
                url: "http://kushal.likhi.me/",
                description: "Hello Its Me, short description, this will show as a text of the link..",
                tags: ["kushal", "likhi"],
                notes: "Notes about kushal - this will show below the link in delicious",
                deliciousConnection: deliciousService.getDeliciousConnection(
                        ConfigurationHolder.config.delicious.username,
                        ConfigurationHolder.config.delicious.password
                ) //Delicious connection should be created once for multiple posts. in this case its created inline
        ))




        render "${r}" // 'r' type Boolean, will return true=success, false = error
    }
}
