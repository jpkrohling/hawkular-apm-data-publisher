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
package org.hawkular.apm.data.publisher.control;

import java.util.logging.Logger;

import org.hawkular.apm.proto.DataPublisherGrpc;
import org.hawkular.apm.proto.Empty;
import org.hawkular.apm.proto.SpanRequest;

import io.grpc.stub.StreamObserver;

/**
 * @author Juraci Paixão Kröhling
 */
public class SpanPublisher extends DataPublisherGrpc.DataPublisherImplBase {
    private static final Logger logger = Logger.getLogger(SpanPublisher.class.getName());

    @Override
    public void publish(SpanRequest request, StreamObserver<Empty> responseObserver) {
        logger.finest(String.format("Sending the following span to the persistent data API: %s", request.getName()));
        responseObserver.onNext(Empty.newBuilder().build());
        responseObserver.onCompleted();
    }
}
