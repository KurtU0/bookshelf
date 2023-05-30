# Bookshelf

Bookshelf was created as a final project for an OOP (object-oriented programming course). The following is the documentation that was submitted along with the code for the program.

## Introduction

Bookshelf is an interactive reading management tool with basic CRUD (create, read, update, delete) capabilities. I was motivated to create this project after looking for a locally hosted service that will keep track of my progress in as many books as I want. 

## Purpose

Bookshelf is an command line tool for users who want to keep track of their progress in several books at once. Books are sorted by user defined categories and can be updated or deleted when progress is made. Privacy concerned users might opt for this service over others due to its nature as being a purely local service with no internet connectivity.

## Functionality

### User Accounts and Object Serialization

Every unique user has their own “shelf” of books in their own collections. When the program runs, users are instructed to enter their name. The program will create a new user instance if there is no existing username, otherwise, the program will load that user’s file directly.

### Main Menu and CRUD Features

The main menu presents itself after every choice a user makes. From the main menu users can interact with the program’s CRUD features. Users can create a new collection, add books to an existing collection, update their progress on a book, delete a book, or view all of their books and progress. If the user views the shelf, they are presented with text UI showing the details of the book. This also shows progress represented visually with a progress bar, as well as with a percentage indicator. When the user exits the program, their progress is serialized and saved.

### User Experience

Users are guided through the program by messages that give them proper feedback. They are
guided through the collection creation and add/update/deletion processes.

### Saving and Loading User Data

At the beginning of every session the user is prompted to enter their name. In the case that this
is a new user, the program will create a new serializable instance in the users directory. This
instance will be serialized and saved at the end of the session. When a user logs in again with
the same name, their file will be deserialized and accessible through the same methods as
before.

### Test User

If you enter the name “Kurt” at the beginning of the session, my file will load. Viewing my shelf
will show a sample output of what the user will see when they add multiple books to their
collections.
