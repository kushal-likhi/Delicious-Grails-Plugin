package org.ig.grails.plugin.delecious

/**
 * Created by IntelliJ IDEA.
 * User: kushal
 * Date: 9/21/11
 * Time: 11:34 AM
 * To change this template use File | Settings | File Templates.
 */
class DeliciousResponse<T> {

    public T entity
    public int status

    public boolean success() {
        return this.status == 200 || this.status == 201
    }

    public String toString() {
        return "Delicious Response: Status: ${status}, Response Entity: ${entity}"
    }
}
