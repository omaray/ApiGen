#API Details Page Generator
API Details Page Generator (ApiGen) builds the details page for every Cloud API in all languages.

> Not all languages will be supported at once. Node.js is the first one we'll focus on at first.

The sections below explain each of the folders.

## [PageGen](https://github.com/rok987/ApiGen/tree/master/src/com/api/pagegen)
The API Details Page Generator source code is all located in this folder. The main entry point is the ApiPageGen.java file. Here's a breakdown of the other sub-folders.

###[model](https://github.com/rok987/ApiGen/tree/master/src/com/api/pagegen/model)
There are three main entities that are necessary to create an API Details Page: the api, the language, and the client library. Each file in the model folder contains the definition for each of these entities in the most basic form.

###[dataloader](https://github.com/rok987/ApiGen/tree/master/src/com/api/pagegen/dataloader)
The API Details Page generation needs to show metadata about an API within a certain language - such as client library that can be used, the GitHub location, the API overview link, the API Reference per language, etc. All this information is loaded by a data loader. Currently, there is only one kind of implementation: a file data loader. In other words, all the information is saved in JSON files. We can add more loaders in the future if we can retrieve this information programmatically for instance.

###[manager](https://github.com/rok987/ApiGen/tree/master/src/com/api/pagegen/manager)
There are 4 kinds of mananger: ApiManager, LanguageManager, ClientLibraryManager, and MarkdownManager. Each manager contains all the business logical and is the main interface with the main program (i.e. ApiPageGen.java). These managers are basically managing all the data input (coming from loaders) and offering that information in a certain format as output. The Markdown manager is the one that will generate all the markdown files in the "out" folder.

## [Out](https://github.com/rok987/ApiGen/tree/master/out)
This folder contains all the generated API pages for each language in markdown form. For instance the [Node.js](https://github.com/rok987/ApiGen/tree/master/out/Node.js) contains for instance the content Node developers expect to see for all Cloud APIs.

## [Resources](https://github.com/rok987/ApiGen/tree/master/resources)
This folder contains mainly the API Details template used to generate the all the markdown files. The [Mustache](https://github.com/spullara/mustache.java) template system is used.

The folder also contains all the data sources in JSON files. These data sources represent all the APIs, the lanugages, and the client libraries we know about for Cloud.