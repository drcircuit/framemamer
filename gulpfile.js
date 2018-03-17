const gulp = require('gulp');
const bowerFiles = require('main-bower-files');
const inject = require("gulp-inject");
const path = require('path');
const appPath = "./gui";
const deployPath = "./www";

gulp.task("build", () => {
    console.log(bowerFiles());
    gulp.src(path.join(appPath, "index.html"))
        .pipe(inject(gulp.src(bowerFiles(), {read: false}),{ name: "bower"}))
        .pipe(gulp.dest(deployPath));
});