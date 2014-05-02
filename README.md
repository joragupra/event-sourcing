Event Sourcing
==============

This is just a code sample of Event Sourcing as described by Fowler at the end of this really nice article http://martinfowler.com/eaaDev/EventSourcing.html. The original example was written in C# (and somewhat incomplete). This is just an attemp (using Java just for a personal preference) to make it a little more complete.

From the original source we have the following description of Event Sourcing:

Capture all changes to an application state as a sequence of events.

We can query an application's state to find out the current state of the world, and this answers many questions. However there are times when we don't just want to see where we are, we also want to know how we got there.

Event Sourcing ensures that all changes to application state are stored as a sequence of events. Not just can we query these events, we can also use the event log to reconstruct past states, and as a foundation to automatically adjust the state to cope with retroactive changes.

For more details please take a look at http://martinfowler.com/eaaDev/EventSourcing.html.