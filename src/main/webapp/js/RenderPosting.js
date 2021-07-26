function fetchAllSubmissions() {
    const url = "/demo";
    fetch(url)
        .then(response => {
        return response.json();
        })
        .then(allPostings => {
        const postingContainer = document.getElementById("posting-container");
        if (allPostings.length == 0) {
            allPostings.innerHTML = "<p>You have no matches</p>";
        } else {
            postingContainer.innerHTML = "";
        }
        allPostings.forEach(posting => {    
            console.log(posting)
            const postingDiv = buildPostingDiv(posting);
            postingContainer.appendChild(postingDiv);
      });
    });
}

function buildPostingDiv(posting) {
    const postingDiv = document.createElement("div");
    document.createTextNode(posting.full_name)
    return postingDiv //postingFullNameDiv
}

function buildUI() {
  fetchAllSubmissions();
}