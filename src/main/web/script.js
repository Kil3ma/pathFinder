let currentGrid = [];

function createGrid() {
    let gridService = new GridService();
    currentGrid = gridService.createGrid();
}

function search() {
    const searchService = new SearchService();
    searchService.fetchData(currentGrid)
        .then(data => {
            console.log(data);
            displayGrid(data);
        })
        .catch(error => console.error('Handling error:', error));
}

let selectedPointType = '';

function selectPointType(pointType) {
    selectedPointType = pointType;
}

function placePoint(square, rowIndex, columnIndex, cell) {
    if (selectedPointType) {
        square.classList = 'grid-square';
        square.classList.add(selectedPointType);
        switch(selectedPointType) {
            case 'start':
                currentGrid[rowIndex][columnIndex] = 1;  // Start point
                break;
            case 'obstacle':
                currentGrid[rowIndex][columnIndex] = 3;  // Obstacle
                break;
            case 'end':
                currentGrid[rowIndex][columnIndex] = 2;  // End point
                break;
            default:
                currentGrid[rowIndex][columnIndex] = 0;  // Empty
        }
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
                    square.classList.add('end');
                    break;
                case 3:
                    square.classList.add('obstacle');
                    break;
                case 4:
                    square.classList.add('path');
                    break;
                case 9:
                    square.classList.add('wall');
                    break;
                default:
                    square.classList.add('empty');
            }
            display.appendChild(square);
        });
    });
}


