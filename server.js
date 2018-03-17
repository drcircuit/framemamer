const express = require("express");
const bp = require("body-parser");
const c = require("chalk");
const app = express();
const api = require("./api/api")(require("./storage/inmemoryrepo"));
const port = process.argv.PORT || process.env.PORT || 3000;

app.use(bp.urlencoded({extended: false}));
app.use(bp.json());
api.resources.forEach((r) => {
    app.use(r.resource, r.handler);
})
app.use("/", express.static("./www"));
app.use("/bower_components", express.static("./bower_components"));

app.listen(port, () =>{
    console.log("The ", c.cyan("FrameMamer"), " server is listening on port [", c.green(port), "]");
});
