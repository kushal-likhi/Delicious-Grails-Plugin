package org.ig.grails.plugin.delicious

import org.codehaus.groovy.grails.commons.ConfigurationHolder
import del.icio.us.Delicious
import org.ig.grails.plugin.delecious.DeliciousPost

class DeliciousService {

    static transactional = false

    private static config = ConfigurationHolder.config

    /*
     * To get the delicious Object to work upon
     */

    public Delicious getDeliciousConnection(
            String username,
            String password
    ) {
        return new Delicious(username, password)
    }

    public Delicious getDeliciousConnection(
            String apiEndpoint,
            String username,
            String password
    ) {
        return new Delicious(username, password, apiEndpoint)
    }

    public Delicious getDeliciousConnection(
            String username,
            String password,
            String apiEndpoint,
            String proxyHost,
            int proxyPort
    ) {
        return new Delicious(username, password, apiEndpoint, proxyHost, proxyPort)
    }

    /*
    * Add Post to Delicious
    */

    public boolean postNewBookmark(DeliciousPost deliciousPost) {
        return deliciousPost.deliciousConnection.addPost(
                deliciousPost.url,
                deliciousPost.description,
                deliciousPost.notes,
                deliciousPost.tags.join(" "),
                deliciousPost.date,
                deliciousPost.replace,
                deliciousPost.shared
        )
    }
}
