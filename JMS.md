# JMS
JMS supports two models for messaging:
1. Queue (point to point).
2. Topic (publish-subscribe).
## Queue
  * It enables one-to-one communication. It is also called point-to-point communication.
  * The sender will deliver a message to the queue and single receivers will pick the message from the queue.
  * The receiver doesn't need to listen to queue at the time when the message is sent to the queue.

## Topic
  * It enables one-to-many communication. It is also called publish-subscribe communication.
  * The publisher will deliver the message to a topic and it will be received by all subscribers who are actively listening to the topic.
  * A subscriber will miss the published message if it is not actively listening to the topic unless messages are made durable.

  
