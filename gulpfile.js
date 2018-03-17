const gulp = require("gulp");
const bowerFiles = require("main-bower-files");
const inject = require("gulp-inject");
const path = require("path");
const angularTemplates = require("gulp-angular-templatecache");
const rename = require("gulp-rename");
const sass = require("gulp-sass");
const appPath = "./gui";
const deployPath = "./www";


gulp.task("build",["html"], () => {
    console.log(bowerFiles());

    gulp.src(path.join(appPath,"app/*.js"))
        .pipe(gulp.dest(path.join(deployPath, "app")));
    gulp.src(path.join(appPath,"assets/*.*"))
        .pipe(gulp.dest(path.join(deployPath, "assets")));
    gulp.src(path.join(appPath, "style/**/*.scss"))
        .pipe(sass())
        .pipe(gulp.dest(path.join(deployPath, "style")))
    gulp.src(path.join(appPath, "index.html"))
        .pipe(inject(gulp.src(bowerFiles(), {read: false}),{ name: "bower"}))
        .pipe(inject(gulp.src(path.join(deployPath, "app/*.js"), {read: false}),{ignorePath: "www"}))
        .pipe(inject(gulp.src(path.join(deployPath, "style/*.css"), {read: false}),{ignorePath: "www"}))
        .pipe(gulp.dest(deployPath));
});

gulp.task("html", function () {
    return gulp.src(path.join(appPath,"app/partials/**/*.html"))
        .pipe(angularTemplates({module: "allpartials", root: "partials/", filename: "allPartials.js", standalone:true}))
        .pipe(gulp.dest("./www/app/"));
});