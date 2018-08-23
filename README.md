# copy-constraints-bug

./gradlew integrationTest fails with error
 
```
org.grails.datastore.mapping.validation.ValidationErrors: 2 errors
Field error in object 'copy.bug.WorkingPeriod' on field 'class': rejected value [null]; codes [copy.bug.WorkingPeriod.class.typeMismatch.error,copy.bug.WorkingPeriod.class.typeMismatch,workingPeriod.class.typeMismatch.error,workingPeriod.class.typeMismatch,typeMismatch.copy.bug.WorkingPeriod.class,typeMismatch.class,typeMismatch.java.lang.Class,typeMismatch]; arguments [class]; default message [Cannot set readonly property: class for class: copy.bug.WorkingPeriod]
Field error in object 'copy.bug.WorkingPeriod' on field 'note': rejected value [null]; codes [copy.bug.WorkingPeriod.note.nullable.error.copy.bug.WorkingPeriod.note,copy.bug.WorkingPeriod.note.nullable.error.note,copy.bug.WorkingPeriod.note.nullable.error.java.lang.String,copy.bug.WorkingPeriod.note.nullable.error,workingPeriod.note.nullable.error.copy.bug.WorkingPeriod.note,workingPeriod.note.nullable.error.note,workingPeriod.note.nullable.error.java.lang.String,workingPeriod.note.nullable.error,copy.bug.WorkingPeriod.note.nullable.copy.bug.WorkingPeriod.note,copy.bug.WorkingPeriod.note.nullable.note,copy.bug.WorkingPeriod.note.nullable.java.lang.String,copy.bug.WorkingPeriod.note.nullable,workingPeriod.note.nullable.copy.bug.WorkingPeriod.note,workingPeriod.note.nullable.note,workingPeriod.note.nullable.java.lang.String,workingPeriod.note.nullable,nullable.copy.bug.WorkingPeriod.note,nullable.note,nullable.java.lang.String,nullable]; arguments [note,class copy.bug.WorkingPeriod]; default message [Property [{0}] of class [{1}] cannot be null]
	at copy.bug.ApiController.$tt__save(ApiController.groovy:21)
```

after binding  
```groovy
//        bindData(period, command, [exclude: ['hours','class', 'constraints']]) //works
//        bindData(period, command) //works
        bindData(period, command, [exclude: ['hours']]) // fails

```

class -- native field
note -- has nullable: true

