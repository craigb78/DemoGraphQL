https://www.pluralsight.com/guides/building-a-graphql-server-with-spring-boot

http://localhost:8080/graphiql


```shell
mutation newDOnald {
  newAuthor(firstName: "Donald", lastName: "Duck") {
    id
    firstName
  }
}

mutation newBook {
  newBook(title:"Tom Sawyer", isbn: "0024-424", pageCount: 100, author:2) {
    id
  }
}

query get_all_Authors {
  findAllAuthors {
    id
    firstName
    lastName
  }
}


query get_all_Books {
  findAllBooks {
    id
    title
  }
}

```