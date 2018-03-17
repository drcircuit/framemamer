const transpilationPath = "./transpile";
const path = require("path");
const {exec} = require("child_process");
const resPath = "../../RES.jar";
const fs = require("fs");
const pp = "com.framemamer.program";
const dp = "com.framemamer.data";

module.exports = {    
    compile: (file, cb) => {
        let codePath = path.join(transpilationPath,file.filename);
        fs.mkdirSync(codePath);
        let cmd = "java -jar " + resPath + " -javatype -dp \""+dp+"\" -pp \""+pp+"\" "+path.join("../../",file.path);
        exec(cmd,{
            cwd: path.join(transpilationPath, file.filename)}, function(error, stdout, stderr){
                console.log(error);
                var err = stderr.split(/\r?\n/);
                var long = stdout.split(/\r?\n/);
                var datadir = path.join(codePath, dp.split(".").join("/"));
                var programdir = path.join(codePath, pp.split(".").join("/"));
                var datafiles = [];
                var programfiles = [];

                if(fs.existsSync(datadir)){
                    fs.readdirSync(datadir).forEach((f) =>{
                        datafiles.push(f);
                    });
                }
                if(fs.existsSync(programdir)){
                    fs.readdirSync(programdir).forEach((f) =>{
                        programfiles.push(f);
                    });
                }
                console.log(datafiles, programfiles);
                cb({dataClasses: datafiles, programClasses: programfiles, path: codePath, dp:dp, pp:pp, id: file.filename});
            }
        );        
    }
}