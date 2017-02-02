/*
 * Copyright 2017 Juraci Paixão Kröhling
 * and other contributors as indicated by the @author tags.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.hawkular.apm.data.publisher.boundary;

import java.io.IOException;

import org.hawkular.apm.data.publisher.control.SpanPublisher;

import io.grpc.ServerBuilder;

/**
 * @author Juraci Paixão Kröhling
 */
public class DataPublisherServer {
    public static void start(String bindTo, int port) {
        try {
            ServerBuilder.forPort(port)
                    .addService(new SpanPublisher())
                    .build()
                    .start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
