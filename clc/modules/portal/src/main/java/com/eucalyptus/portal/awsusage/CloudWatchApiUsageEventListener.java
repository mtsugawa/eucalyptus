/*************************************************************************
 * (c) Copyright 2017 Hewlett Packard Enterprise Development Company LP
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; version 3 of the License.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see http://www.gnu.org/licenses/.
 ************************************************************************/
package com.eucalyptus.portal.awsusage;

import javax.annotation.Nonnull;
import org.apache.log4j.Logger;
import com.eucalyptus.bootstrap.Bootstrap;
import com.eucalyptus.event.Listeners;
import com.eucalyptus.portal.BillingProperties;
import com.eucalyptus.reporting.event.CloudWatchApiUsageEvent;

/**
 *
 */
public class CloudWatchApiUsageEventListener extends SensorQueueEventListener<CloudWatchApiUsageEvent> {
  private static final Logger LOG = Logger.getLogger( LoadBalancerUsageEventListener.class );

  public static void register( ) {
    Listeners.register( CloudWatchApiUsageEvent.class, new CloudWatchApiUsageEventListener( ) );
  }

  @Override
  public void fireEvent( @Nonnull final CloudWatchApiUsageEvent event ) {
    if ( !Bootstrap.isOperational( ) || !BillingProperties.ENABLED ) {
      return;
    }

    transformAndQueue( LOG, event, QueuedEvents.FromCloudWatchApiUsageEvent );
  }
}
