let express = require("express");
let bp = require("body-parser");
let c = require("chalk");
let app = express();
let port = process.argv.PORT || process.env.PORT || 3000;

app.use(bp.urlencoded({extended: false}));
app.use(bp.json());
app.use("/", express.static("./www"));
app.use("/bower_components", express.static("./bower_components"));

app.listen(port, () =>{
    console.log("The ", c.cyan("FrameMamer"), " server is listening on port [", c.green(port), "]");
});
