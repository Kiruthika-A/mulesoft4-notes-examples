# Flow Controls
* Scatter and Gather:
  * Runs all the events in parallel
  * Response format will be {
    0={
      payload=...
      attributes=...
    },
    1={
      payload=...
      attributes=...
    }
  }
  * If there is no Payload when starting the scatter and gather flow we will get `Cannot copy message with a stream payload. Payload can be transformed by using an <object-to-byte-array-transformer> in order to be able to copy the message. Payload type is "org.mule.runtime.core.internal.streaming.bytes.ManagedCursorStreamProvider"` Error.
  * On Error in any Route- The MULE:COMPOSITE_ERROR error object gathers together not only the errors from the route that failed, but also the Mule events from completed routes.
    Payload can be accessed from `error.errorMessage.payload.results`
    Failues can be accessed from `error.errorMessage.payload.failures`
* Round Robin
* Choice 
