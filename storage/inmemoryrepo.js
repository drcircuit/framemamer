const fs = require("fs");
const path = require("path");
const dir = "./transpile";
const hl = require("pygments").colorize;

module.exports = function (scope) {

    return {
        save: (obj) => {
            var subdir = path.join(dir, obj.id);
            var pkgpp = path.join(subdir, obj.pp.split(".").join("/"));
            var pkgdp = path.join(subdir, obj.dp.split(".").join("/"));
            var manifest = { id: obj.id, pp: obj.pp, dp: obj.dp, cobol: obj.cobol };
            if (!fs.existsSync(subdir)) {
                fs.mkdirSync(subdir);
            }
            let files = obj.dataClasses.map((f) => {
                return { file: path.join(pkgdp, f), pkg: obj.dp }
            }).concat(obj.programClasses.map((f) => {
                return { file: path.join(pkgpp, f), pkg: obj.pp }
            }));
            let rq = files.map((f) => {
                return new Promise((resolve) => {
                    hl(f.file, "java", "html", (data) => {
                        fs.writeFileSync(f.file + ".html", data);
                        f.html = f.file + ".html";
                        resolve(f);
                    });
                })
            });
            Promise.all(rq)
                .then((classes) => {
                    var progs = classes.filter((c) => { return c.pkg === obj.pp; });
                    var data = classes.filter((c) => { return c.pkg === obj.dp; });
                    manifest.dataClasses = data;
                    manifest.programClasses = progs;
                    fs.writeFileSync(path.join(subdir, "manifest.json"), JSON.stringify(manifest));
                });
        },
        load: (id) => {
            var subdir = path.join(dir, id);
            if (fs.existsSync(path.join(subdir, "manifest.json"))) {
                var model = JSON.parse(fs.readFileSync(path.join(subdir, "manifest.json").toString()));
                model.dataClasses.map((dc) => {
                    var html = fs.readFileSync(path.join("./", dc.html)).toString();
                    dc.dataHtml = html;
                });
                model.programClasses.map((pc) => {
                    var html = fs.readFileSync(path.join("./", pc.html)).toString();
                    pc.dataHtml = html;
                })
                return model;
            } else {
                return null;
            }

        }
    }
}