# MVVMJavaAnroid

# Why use Paging?
Assume you have more than 1000 items for your list that you are fetching from a backend server. Here are the cons if you are fetching everything at once.

## Disadvantages of not using Paging
    User do not see all the items at once, but you are fetching everything at once, so it will consume more bandwidth uselessly.
    Creating a large List at once uses more system resources resulting in a lagging app and bad user experience.

## Advantages of using Paging
    You will only load a small chunk from your large data set, it will consume less bandwidth.
    The app will use less resources resulting in a smooth app and nice user experience.

## Android Paging Library
Android paging library is a component of android jetpack. Remember it is not available by default so we need to add it. It helps us to load data gradually and gracefully in our application’s RecyclerView.

In this Android Paging Library Tutorial I will not tell you about the theoretical things about the library. Because to know this thing you can visit the official documentation. Instead of discussing the theoretical bla bla bla we will learn implementing the library in our application, as the official documentation might confuse you.

For more Info
* https://www.simplifiedcoding.net/android-paging-library-tutorial/

===================================================================================================

# Why WorkManager
Since Marshmallow, The Android dev team is continuously working on battery optimizations. After that team introduced Doze mode. Then in Oreo imposed various kind of limitation on performing background jobs. Before WorkManager, we use various job scheduler for performing background task, such as Firebase JobDispatcher, Job Scheduler and Alarm Manager + Broadcast receivers. So for the developer perspective, it is difficult to choose which scheduler should use and which one is good. So the Work Manager handles these kinds of stuff. We have to pass the task to the WorkManager and It uses all this Firebase Job Dispatcher, Alarm Manager + Broadcast Receivers, Job Scheduler to perform the background task depending on the requirement.

## What is WorkManager?
WorkManager is basically a task scheduler, It makes it easy to specify the asynchronous task and when they should run. The Work Manager API helps create the task and hand it to the Work Manager to run immediately or at an appropriate time as mentioned. For example, you might point your app to download new resources from the network from time to time and now the downloading is a task and you can set up this task to run at an appropriate time depending on the availability of the WIFI network or when the device is charging. So this way you can schedule a task using WorkManager.
Advantages of WorkManager

    * It provides guaranteed and constraint-aware execution. In other words, You can schedule a task depending on the condition when they should run. So WorkManager will take care of all the constraints and give the guarantee that the task will be executed even when the device is rebooted are the app is exited without executing the task and our task will be executed.
    
    * It provides backward compatibility which means you don’t need to figure out the device capabilities or choose an appropriate API. You have to just hand off the task to the WorkManager. It will choose the best option for the execution of the task.
    
   * WorkManager supports tasks query, You can not only schedule the task but if you have quite some work or the tasks, you can actually check the status of the state of the task, whether it is running or whether it is quit or it has succeeded or failed. so you can detect the status of tasks.
   
    * It supports task chaining, this means you can create a draft of your work and enqueue one after the other using the Work Manager.

## How it works
Before moving forward, We have to understand the class and concept of WorkManager. Let’s understand what are various base classes that are used for Job Scheduling.

## Worker
It specifies what task to perform, The WorkManager API include an abstract worker class and You need to extends this class and perform the work.

## WorkRequest
WorkRequest represents an individual task that is to be performed. Now this WorkRequest, you can add values details for the work. Such as constraint or you can also add data while creating the request
WorkRequest can be of to type

    OneTimeWorkRequest– That means you requesting for non-repetitive work.
    PeriodicWorkRequest– This class is used for creating a request for repetitive work

## WorkManager
The WorkManager class in enqueues and manages all the work request. We pass work request object to this WorkManager to enqueue the task.

## WorkInfo
WorkInfo contains the information about a particular task, The work manager provides LiveData for each of the work request objects, We can observe this and get the current status of the task.
Step for implementation WorkManager to Schedule Tasks
For more detail read
* https://androidwave.com/scheduling-recurring-task-in-android-workmanager/
* https://androidwave.com/android-workmanager-tutorial/
* https://androidwave.com/workmanager-constraints/
