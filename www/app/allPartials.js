angular.module('allpartials', []).run(['$templateCache', function($templateCache) {$templateCache.put('partials/banner.html','<h2>There is a banner here...</h2>');
$templateCache.put('partials/code.html','<div class="row m-b-1">\r\n    <div class="col-sm-8 offset-sm-2">\r\n        <div>\r\n            <strong class="text-info">{{title}} <span ng-if="pkg">{{pkg}}</span></strong>\r\n            \r\n        </div>\r\n        <div ng-bind-html="source"></div>\r\n    </div>\r\n</div>\r\n<div class="row m-b-1">\r\n    <div class="col-sm-8 offset-sm-2">\r\n        <a href="{{resource}}">{{resource}}</a>\r\n    </div>\r\n</div>');
$templateCache.put('partials/home.html','<header class="py-5 bg-image-full header-img">\r\n    <div class="text-white text-center">\r\n        <h1>Frame Mamer</h1>\r\n        <strong class="text-white">Your <span class="text-primary">GOTO</span> place for <span class="text-info">COBOL</span> transpiling</strong>\r\n    </div>\r\n</header>\r\n<upload-form></upload-form>');
$templateCache.put('partials/uploader.html','<div class="py-5">\r\n    <div class="row m-b-1">\r\n        <div class="col-sm-6 offset-sm-3">\r\n            <button type="button" class="btn btn-primary btn-block" onclick="document.getElementById(\'inputFile\').click()">Upload COBOL source code</button>\r\n            <div class="form-group inputDnD">\r\n                <label class="sr-only" for="inputFile">File Upload</label>\r\n                <input upload-handler type="file" class="form-control-file text-primary font-weight-bold" id="inputFile" data-title="Drag and drop a file">\r\n            </div>\r\n        </div>\r\n    </div>\r\n</div>\r\n<div class="py-5">\r\n    <div ng-if="file" class="highlight">\r\n        <strong class="text-info">\r\n            <div class="row  m-b-1">\r\n                <div class="col-md-6">\r\n                    <div class="col-sm-6 offset-sm-2">\r\n                        <i class="fas fa-save"></i> Cobol source\r\n                    </div>\r\n\r\n                    <div class="col-sm-4 offset-sm-2">\r\n                        <a class="btn-info btn" ng-if="file.resource && !waiting" href="{{file.resource}}/zip">\r\n                            <i class="fas fa-download"></i> Download Java Source</a>\r\n                    </div>\r\n                    <code source="file.source" title="{{file.name}}" resource="{{file.resource}}"></code>\r\n                </div>\r\n            </div>\r\n        </strong>\r\n\r\n\r\n    </div>\r\n\r\n</div>\r\n<div class="py-5" ng-show="waiting">\r\n    <div class="text-center">\r\n        <p>\r\n            <span class="glyphicon glyphicon-refresh glyphicon-refresh-animate"></span>\r\n        </p>\r\n        <p>Loading...</p>\r\n    </div>\r\n</div>\r\n\r\n<div ng-show="!waiting && transpiled">\r\n    <div class="py-5">\r\n        <div class="highlight row m-b-1">\r\n            <div ng-if="transpiled.dataClasses.length > 0" class="col-md-6">\r\n                <div class="row">\r\n                    <div class="col-sm-6 offset-sm-2">\r\n                        <strong class="text-info">\r\n                            <i class="fas fa-cube"></i> Data Java Classes</strong>\r\n                    </div>\r\n                </div>\r\n                <code ng-repeat="dc in transpiled.dataClasses" source="dc.dataHtml" title="{{dc.file}}" pkg="{{dc.pkg}}"></code>\r\n            </div>\r\n            <div ng-if="transpiled.programClasses.length > 0" class="col-md-6">\r\n                <div class="row">\r\n                    <div class="col-sm-6 offset-sm-2">\r\n                        <strong class="text-info">\r\n                            <i class="fas fa-coffee"></i> Program Java Classes</strong>\r\n                    </div>\r\n                </div>\r\n                <code ng-repeat="pc in transpiled.programClasses" source="pc.dataHtml" title="{{pc.file}}" pkg="{{pc.pkg}}"></code>\r\n            </div>\r\n        </div>\r\n    </div>\r\n</div>');}]);