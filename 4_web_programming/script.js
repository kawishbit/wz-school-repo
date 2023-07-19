let tableHeader = ["#", "Book Title", "Author", "Year",];
let tableData = [
    ["#1", "Book 1", "Author 1", "2001"],
    ["#2", "Book 2", "Author 2", "2002"],
    ["#3", "Book 3", "Author 3", "2003"],
    ["#4", "Book 4", "Author 4", "2004"],
    ["#5", "Book 5", "Author 5", "2005"],
    ["#6", "Book 6", "Author 6", "2006"],
    ["#7", "Book 7", "Author 7", "2007"],
    ["#8", "Book 8", "Author 8", "2008"],
    ["#9", "Book 9", "Author 9", "2009"],
    ["#10", "Book 10", "Author 10", "2010"],
    ["#11", "Book 11", "Author 11", "2011"],
    ["#12", "Book 12", "Author 12", "2012"],
    ["#13", "Book 13", "Author 13", "2013"],
    ["#14", "Book 14", "Author 14", "2014"],
    ["#15", "Book 15", "Author 15", "2015"],
    ["#16", "Book 16", "Author 16", "2016"],
    ["#17", "Book 17", "Author 17", "2017"],
    ["#18", "Book 18", "Author 18", "2018"],
    ["#19", "Book 19", "Author 19", "2019"],
    ["#20", "Book 20", "Author 20", "2020"],
];

generateTableById("mainTable", tableHeader, tableData);

function generateTableById(id, tableHeader, tableData) {

    let table = document.getElementById(id);
    let thead = document.createElement("thead");
    let tbody = document.createElement("tbody");

    table.appendChild(thead);
    table.appendChild(tbody);

    let theadTr = document.createElement("tr");
    thead.appendChild(theadTr);

    for (const thItem of tableHeader) {
        let th = document.createElement("th");
        th.innerHTML = thItem;
        theadTr.appendChild(th);
    }


    for (const trItems of tableData) {
        let tbodyTr = document.createElement("tr");
        tbody.appendChild(tbodyTr);
        for (const tdItem of trItems) {
            let td = document.createElement("td");
            td.innerHTML = tdItem;
            tbodyTr.appendChild(td);
        }
    }
}