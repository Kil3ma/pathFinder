let currentGrid = [];

function createGrid() {
    const width = document.getElementById('width').value;
    const height = document.getElementById('height').value;

    fetch('http://localhost:8080/pathfinder/grid', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({ width, height }),
    })
        .then(response => response.json())
        .then(data => {
            currentGrid = data;
            displayGrid(data);
        })
        .catch(error => console.error('Error:', error));
}

function setStartPoint() {
    const x = document.getElementById('pointX').value;
    const y = document.getElementById('pointY').value;
    const type = document.getElementById('pointType').value;

    fetch('http://localhost:8080/pathfinder/grid-setup/point', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({ grid: currentGrid, x, y, type }),
    })
        .then(response => response.json())
        .then(data => {
            currentGrid = data;
            displayGrid(data);
        })
        .catch(error => console.error('Error:', error));
}

let selectedPointType = '';

function selectPointType(pointType) {
    selectedPointType = pointType;
}

function placePoint(square, rowIndex, columnIndex, cell) {
    if (selectedPointType) {
        square.classList = 'grid-square'; // Resetuje poprzednie klasy
        square.classList.add(selectedPointType);
    }
}


function displayGrid(grid) {
    const display = document.getElementById('gridDisplay');
    display.innerHTML = '';

    const columns = grid[0].length;
    display.style.gridTemplateColumns = `repeat(${columns}, 20px)`;

    grid.forEach((row, rowIndex) => {
        row.forEach((cell, columnIndex) => {
            const square = document.createElement('div');
            square.classList.add('grid-square');
            square.addEventListener('click', () => placePoint(square, rowIndex, columnIndex, cell));

            switch(cell) {
                case 0:
                    square.classList.add('empty');
                    break;
                case 1:
                    square.classList.add('start');
                    break;
                case 2:
                    square.classList.add('obstacle');
                    break;
                case 3:
                    square.classList.add('end');
                    break;
                default:
                    square.classList.add('empty');
            }
            display.appendChild(square);
        });
    });
}


