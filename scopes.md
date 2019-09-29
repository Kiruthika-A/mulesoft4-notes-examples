# Objects scope:
* Consider a Flow
  http-listner --> setVariable ( v = 10) --> Http_request --> logger
  * Variable will be same before and after the http request call
  * Payload, Attributes and Query params will be changed depends on the http response
* Consider a flow
  http-listner --> setVariable ( v = 10) --> FlowReference (subflow) --> logger
  * Variables, Payload, attributes and Queryparams are accessible in the subflow.

# VM Connectors:
  * Publish and consume : Synchronous
  * Publish : Async
  * Consume
  * Listner
