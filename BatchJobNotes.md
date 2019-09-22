#Batch Job
Will accept only Array types as payloads
Splits the Array into records and process each record
Works in multi threaded ( 16 thread is assigned as default ).
##Scopes:
*Variables in one step is accessible and can be modified to next batch steps.
*All Variables are different for each record's batch job
*Variable defined OUTSIDE the batch job
  * Inside the step - accessible or changed and can be shared between steps
  * Inside the Aggregator - accessible
  * Inside On complete - accessible , but changes made inside the steps are not visible here.
*Variables Defined INSIDE the Batch step.
  * Inside the step - accessible
  * Between step - accessible and can be modified
  * Inside the Aggregator - NOT accessible
  * Inside On complete - NOT accessible
*Payload Access level
  * Between step - accessible and can be modified
  * Inside the Aggregator - accessible and displayed depends on the Aggregator size.
  * Inside On complete- we will get only BatchJobInstanceId . if you log that you will get only             BatchJobInstanceId:09b38430-8474-11e4-9c5c-0a0027000000
  Number of TotalRecords: 0
  ProcessedRecords: 0
  Number of sucessfull Records: 0
  Number of failed Records: 0
  ElapsedTime in milliseconds: 0
*Payload or Variable will NOT be shared between different record's batch job ( irrespective of its scope - inside/outside of batch job).
##Errors:
*Errors in one step on the on record
  *Will skip only that record and process the other records.
  *Following steps on the error record will NOT be processed.
