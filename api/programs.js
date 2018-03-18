const express = require("express");
const hl = require("pygments").colorize;
const multer = require('multer')
const upload = multer({ dest: 'uploads/' })
const unzip = require("extract-zip");
const z = require("is-zip-file");
const resolve = require('path').resolve
const fs = require("fs");
const cobol = require("../transpiler/cobol");
const path = require("path");
const archiver = require("archiver");
module.exports = function (repo) {
    var routes = express.Router();

    routes.get("/:id", (req, res) => {
        var fullUrl = req.protocol + '://' + req.get('host') + req.originalUrl;
        var thing = repo.load(req.params.id);        
        if (thing) {
            thing.dl = fullUrl + '/zip';
            res.json(thing);
        } else {
            res.send(404);
        }

    });
    routes.get("/:id/zip", (req, res) => {
        console.log(req.params.id);
        var obj = repo.load(req.params.id);
        var archive = archiver('zip', {
            zlib: { level: 9 } // Sets the compression level.
        });
        res.writeHead(200, {
            'Content-Type': 'application/zip',
            'Content-disposition': 'attachment; filename=javasource.zip'
        });

        archive.pipe(res);
        archive.directory(path.join("./transpile/",obj.id, "/com/"));
        archive.finalize();
    });
    routes.post("/", upload.single("source"), (req, res) => {
        let file = req.file;
        var fullUrl = req.protocol + '://' + req.get('host') + req.originalUrl;
        if (z.isZipSync(file.path)) {
            unzip(file.path, { dir: resolve("./uploads/" + file.filename) }, function (err) {
                if (err) {
                    console.log(err);
                }
                res.json({ id: file.filename });
            });
        } else {

            try {
                hl(file.path, "cobol", "html", (data) => {
                    cobol.compile(file, (result) => {
                        console.log(result);
                        result.cobol = data;
                        repo.save(result);
                    });

                    res.json({ id: file.filename, name: file.originalname, highlighted: data, resource: fullUrl + '/' + file.filename });
                });

            } catch (e) {
                console.log(e);
                res.send(400);
            }
        }
    });
    return routes;
}