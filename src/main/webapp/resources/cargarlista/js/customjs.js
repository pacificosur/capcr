/* global XLSX */

(function () {

    var app = angular.module('myApp', []);
    app.controller('MyController', ['$scope', myController]);

    var excelJsonObj = [];

    function myController($scope) {

        $scope.uploadExcel = function () {

            var myFile = document.getElementById('file');
            var input = myFile;
            var reader = new FileReader();

            reader.onload = function () {
                var fileData = reader.result;
                var workbook = XLSX.read(fileData, {type: 'binary'});

                workbook.SheetNames.forEach(function (sheetName) {
                    var rowObject = XLSX.utils.sheet_to_row_object_array(workbook.Sheets[sheetName]);
                    excelJsonObj = rowObject;
                });

                for (var i = 0; i < excelJsonObj.length; i++) {
                    var data = excelJsonObj[i];
                    $('#myTable tbody:last-child').append("<tr><td><input type='text' value='" + data.MATRICULA + "' name='matricula" + i + "'></td><td><input type='text' value='" + data.NOMBRE + "' name='nombre" + i + "'></td><td><input type='text' value='" + data.GRUPO + "' name='grupo" + i + "'></td><td><input type='text' value='" + data.SEMESTRE + "' name='semestre" + i + "'></td><td><input type='text' value='" + data.CARRERA + "'name='carrera" + i + "'></td></tr>");
                }
                $('#numAlumnos').val(+excelJsonObj.length);
                $('#btn-cargar-alumno').prop('disabled', 'true');
            };
            reader.readAsBinaryString(input.files[0]);
        };

        $scope.uploadExcel2 = function () {

            var myFile = document.getElementById('file2');
            var input = myFile;
            var reader = new FileReader();

            reader.onload = function () {
                var fileData = reader.result;
                var workbook = XLSX.read(fileData, {type: 'binary'});

                workbook.SheetNames.forEach(function (sheetName) {
                    var rowObject = XLSX.utils.sheet_to_row_object_array(workbook.Sheets[sheetName]);
                    excelJsonObj = rowObject;
                });

                for (var i = 0; i < excelJsonObj.length; i++) {
                    var data = excelJsonObj[i];
                    $('#myTable2 tbody:last-child').append("<tr><td><input type='text' value='" + data.CODIGO + "' name='codigo" + i + "'></td><td><input type='text' value='" + data.NOMBRE + "' name='nombre" + i + "'></td><td><input type='text' value='" + data.SEMESTRE + "' name='semestre" + i + "'></td><td><input type='text' value='" + data.CARRERA + "'name='carrera" + i + "'></td></tr>");
                }
                $('#numPracticas').val(+excelJsonObj.length);
                $('#btn-cargar-practica').prop('disabled', 'true');

            };
            reader.readAsBinaryString(input.files[0]);
        };
    }
})();