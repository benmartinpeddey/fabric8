/**
 *  Copyright 2005-2015 Red Hat, Inc.
 *
 *  Red Hat licenses this file to you under the Apache License, version
 *  2.0 (the "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 *  implied.  See the License for the specific language governing
 *  permissions and limitations under the License.
 */
package io.fabric8.gateway.handlers.detecting.protocol.openwire.command;

import org.fusesource.hawtbuf.UTF8Buffer;

/**
 * @openwire:marshaller code="9"
 * @version $Revision: 1.7 $
 */
public class RemoveSubscriptionInfo extends BaseCommand {

    public static final byte DATA_STRUCTURE_TYPE = CommandTypes.REMOVE_SUBSCRIPTION_INFO;

    protected ConnectionId connectionId;
    protected UTF8Buffer clientId;
    protected UTF8Buffer subscriptionName;

    public byte getDataStructureType() {
        return DATA_STRUCTURE_TYPE;
    }

    /**
     * @openwire:property version=1 cache=true
     */
    public ConnectionId getConnectionId() {
        return connectionId;
    }

    public void setConnectionId(ConnectionId connectionId) {
        this.connectionId = connectionId;
    }

    /**
     * @openwire:property version=1
     */
    public UTF8Buffer getSubscriptionName() {
        return subscriptionName;
    }

    public void setSubscriptionName(UTF8Buffer subscriptionName) {
        this.subscriptionName = subscriptionName;
    }

    /**
     * @openwire:property version=1
     */
    public UTF8Buffer getClientId() {
        return clientId;
    }

    public void setClientId(UTF8Buffer clientId) {
        this.clientId = clientId;
    }

}
