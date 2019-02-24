var links = ["https://www.npr.org/series/494272685/a-silent-epidemic-the-mental-health-crisis-in-our-schools",
"http://neatoday.org/2018/09/13/mental-health-in-schools/",
"http://www.acmh-mi.org/get-help/navigating/problems-at-school/",
"https://www.nasponline.org/resources-and-publications/resources/school-safety-and-crisis/bullying-prevention",
"https://www.stopbullying.gov/",
"https://www.safeschools.com/hot-topics/bullying-prevention/",
"https://www.aft.org/bully",
"https://www.cfchildren.org/resources/bullying-prevention-resources/",
"https://www.pacer.org/bullying/"
];
var index = Math.floor(Math.random() * links.length);
const e = document.getElementById('hiddenLink');
const body= document.getElementsByTagName('body');
e.style.display="block";
e.innerHTML="Bulling Prevention";
e.style.color="white";
e.target="_blank";
e.href=links[index];
e.style.textAlign = "center";
e.style.fontSize = "30px";
e.style.weight="bold";