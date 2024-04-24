var value = [
  {
    title: "H1",
    author: "h1",
    description: "h1",
    price: "h1",
    bookcount: "h1",
  },
  {
    title: "h2",
    author: "h2",
    description: "h2",
    price: "h2",
    bookcount: "h2",
  },
  {
    title: "h3",
    author: "h3",
    description: "h3",
    price: "h3",
    bookcount: "h3",
  },
];
var column = ["title", "author", "description", "price", "bookcount", "Buy"];

for (var j=0;j< value.length;j++) {
  for (var i = 0; i < 5; i++) {
    console.log(value[j][column[i]] );
  }
  console.log("/n")
}
