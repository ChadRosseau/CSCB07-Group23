# Project Description

This file serves as an overview of our application. It includes the descriptions of the functionality for each page in the application, along with a high-level overview of the infrastructure behind the application.

In particular, our application utilizes the MVP architectural pattern throughout the entire application, not just within the login page. To do so it relies on heavily abstracted components designed to maximize efficiency and minimize redundancy, for which we have provided an explanation.

## The Structure

### The View

#### The Activities

Our application includes two main 'Activities' of type `AppCompatActivity`. These are used to distinguish between the two main stages of our app, namely the 'login stage' and the 'main stage'. In particular, certain screen components (such as the Navbar) persist within the activities while moving between fragments. The activities are also used to create 'toasts' (message popups), and navigate between activities and fragments.

#### The Fragments

The fragments are a series of classes extending `BaseFragment`, which extends the Android class `Fragment`. `BaseFragment` is designed to add inherent functionality to every page of our application, in particular faster access to `MainActivityView` via a attribute that prevents repeated calls and casts of `getActivity()`, and an `onDestroy()` method that works with a presenter to prevent memory leaks.

Every fragment will instantiate a corresponding presenter in its `onCreate` method. Here, it will also request a early database retrieval if required. It then uses that presenter to perform operations scoped to the current page and user type. Multiple fragments may use the same presenter, for example, `AdminEventsFragmentView` and `AdminEventsFeedbackView` are both served by `AdminEventsPresenter`, which encompasses the functionality required by both.

Fragments use `onCreateView` to inflate a layout, and `onViewCreated` to access elements in that layout by id and save references.

Fragments that update the screen will contain setting methods that use such references to set screen elements. Notably, these are often used by the presenter within callback functions (explained below). When this is done, the fragment will pass itself as an argument to the presenter method it uses, providing access to its setting methods.

Together, the activities fragments as a collective represent the View.

### The Model

#### The BaseClasses

The BaseClasses are a series of classes designed to exactly model the non-primitive data found at any node in our Firebase Realtime Database. Since these data types map one-to-one to a location in the database, they also possess a static attribute `parentRef` which contains the `DatabaseReference` corresponding to that location.

#### The ListenerTracker

The ListenerTracker class serves as our solution to the memory leaks often created via 'hanging' subscriptions to database nodes, that is to say, listeners that are added to a node but whose references go out of scope and thus cannot be removed. This problem can often compound over many screens until the app visibly slows down.

To address this issue, the ListenerTracker keeps track of a `List` of `ListenerContract`s. Each `ListenerContract` possesses two attributes, one `DatabaseReference` and one `ValueEventListener`. Every time the model wants to a listener to a reference, it passes them both to the `ListenerTracker` which attaches the listener, creates a corresponding contract and saves it to the contract list.

When we want to detach the listeners, such as when navigating to a new page that no longer requires updates, we iterate through the list of contracts and remove the listeners from their corresponding references (see `killListeners()`). This ensures no listeners are left 'hanging', nor do they remain attached longer than necessary.

Each presenter possesses a `ListenerTracker`. When fragments receive the built-in `onDestroy` lifecycle hook signal, they instruct the presenter to `killListeners`, removing the listeners corresponding to that page.

#### The ListenerCallbacks

T

#### The DatabaseModel

The `DatabaseModel` is the workhorse of our application, possessing a variety of generic methods designed to be extremely flexible in nature. In particular, it aims to model any possible desired interaction with the database in as few methods as possible, through using type parameters.

This allows presenters for different pages to access data by providing the database reference they want the data from, the BaseClass that models that data, and a callback lambda function that takes an instance of that BaseClass as a parameter and performs some action with it.

#### The AuthModel

##### The LoginActivityModel

### The Presenters

The presenters are a series of classes designed to handle the majority of the app logic. The idea behind them is that each presenter contains **exactly** one method to communicate between the View and the Model, replacing the traditional approach where there is one method for each direction. Doing so allows the quantity of methods to be halved in the presenter, but crucially massively reduced in the Model (explained below).
