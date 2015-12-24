# Glossator
An incredibly simple way to avoid writing the same RecyclerView.Adapter boilerplate for the 6th time

## What's the point?
I'm a big fan of code reuse. I'm also a big fan of RecyclerView. The view is so common in my apps that almost every screen will have at least one. The most important part of the RecyclerView is the Adapter, which controls the creation of ViewHolders for your different view types and binding data to them.

Every time I would write an Adapter, usually once or twice for each new screen, the code looked extremely similar, as I was following the same pattern. Eventually I wrote a "Base" Adapter that I would subclass to reduce the boilerplate. After a while, I noticed that even all of my subclasses of the Base Adapter looked the same. So now I initialize all my Adapters with a one-liner.
