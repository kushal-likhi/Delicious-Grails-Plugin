package org.ig.grails.plugin.delicious

import org.codehaus.groovy.grails.commons.ConfigurationHolder
import del.icio.us.Delicious
import org.ig.grails.plugin.delecious.DeliciousPost
import org.ig.grails.plugin.delecious.DeliciousResponse

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

    public DeliciousResponse<Boolean> postNewBookmark(DeliciousPost deliciousPost) {
        def dr = new DeliciousResponse<Boolean>(
                entity: deliciousPost.deliciousConnection.addPost(
                        deliciousPost.url,
                        deliciousPost.description,
                        deliciousPost.notes,
                        deliciousPost.tags.join(" "),
                        deliciousPost.date,
                        deliciousPost.replace,
                        deliciousPost.shared
                ),
                status: deliciousPost.deliciousConnection.getHttpResult()
        )
        dr.status = deliciousPost.deliciousConnection.getHttpResult()
        dr
    }


    /*
     * Get Updates For User, Get Pending unread updates since his/her last login
     */

}
