/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
window.onload = function () {
    listFlags();
    getCountryName();
    if (document.title === "Home page") {
        search([clubColor, businessColor, privateColor]);
//        var countries = document.getElementsByClassName('datamaps-subunit');
//        for (var i = 0; i < countries.length; i++) {
//            countries[i].style.opacity = "1";
//
//        }
        var map = new Datamap({
            element: document.getElementById('mapDiv'),
            projection: 'mercator',
            done: function () {},
            responsive: false,
            geographyConfig: {
                highlightFillColor: '#aad',
                highlightBorderWidth: 0.5,
                highlightBorderColor: '#efefef',
                popupOnHover: false,
                highlightOnHover: false,
                borderWidth: 0.5,
                borderOpacity: 1,
                borderColor: '#fff'},
            fills: {
                defaultFill: 'rgba(80,80,80,1)'
            }

        });



    } else {
        //random extra tag to work around caching of images from unsplash on college servers
        //it works but unsplash has a limited number of pics for some countries and tags
        var additionalTags = ["People", "Friends", "Cats", "Dogs", "Home", "Hotel", "Gaming", "Sport", "Cars", "Garden"];
        var randomTag = Math.floor(Math.random() * 10);
        var tagPick = additionalTags[randomTag];
        //
        var country = document.getElementById('flagCountry').innerHTML;
        var img = document.getElementById('bannerImg');
        img.onload = function () {
            document.getElementById('scannerC').style.opacity = "0";
            document.getElementById('bannerImg').classList.add("bgImgFadeIn");
            setTimeout(() => {
                document.getElementById('DCat').style.opacity = "0.8";
                document.getElementById('DEmail').style.opacity = "0.8";
                document.getElementById('contentCont').style.opacity = "1";
                document.getElementById('flagCountry').style.opacity = "1";
                document.getElementById('flagImg').style.opacity = "1";
            }, 300);
        };
        
        img.src = "https://source.unsplash.com/1000x500/?" + country + ", " + tagPick;
    }


    var infoItem = document.getElementById('info');
    infoItem.addEventListener("click", toggleInfoDiv);


};


function mapShow() {
    setTimeout(() => {
        document.getElementById("mapDiv").style.zIndex = "2";
    }, 500);
    document.getElementById("mapDiv").style.opacity = "1";
    document.getElementById("container").style.opacity = "0";

}
function mapHide() {
    setTimeout(() => {
        document.getElementById("mapDiv").style.zIndex = "-2";
    }, 500);
    document.getElementById("mapDiv").style.opacity = "0";
    document.getElementById("container").style.opacity = "1";

}
var iso2ToIso3 = {"BD": "BGD", "BE": "BEL", "BF": "BFA", "BG": "BGR", "BA": "BIH", "BB": "BRB", "WF": "WLF", "BL": "BLM", "BM": "BMU", "BN": "BRN", "BO": "BOL", "BH": "BHR", "BI": "BDI", "BJ": "BEN", "BT": "BTN", "JM": "JAM", "BV": "BVT", "BW": "BWA", "WS": "WSM", "BQ": "BES", "BR": "BRA", "BS": "BHS", "JE": "JEY", "BY": "BLR", "BZ": "BLZ", "RU": "RUS", "RW": "RWA", "RS": "SRB", "TL": "TLS", "RE": "REU", "TM": "TKM", "TJ": "TJK", "RO": "ROU", "TK": "TKL", "GW": "GNB", "GU": "GUM", "GT": "GTM", "GS": "SGS", "GR": "GRC", "GQ": "GNQ", "GP": "GLP", "JP": "JPN", "GY": "GUY", "GG": "GGY", "GF": "GUF", "GE": "GEO", "GD": "GRD", "GB": "GBR", "GA": "GAB", "SV": "SLV", "GN": "GIN", "GM": "GMB", "GL": "GRL", "GI": "GIB", "GH": "GHA", "OM": "OMN", "TN": "TUN", "JO": "JOR", "HR": "HRV", "HT": "HTI", "HU": "HUN", "HK": "HKG", "HN": "HND", "HM": "HMD", "VE": "VEN", "PR": "PRI", "PS": "PSE", "PW": "PLW", "PT": "PRT", "SJ": "SJM", "PY": "PRY", "IQ": "IRQ", "PA": "PAN", "PF": "PYF", "PG": "PNG", "PE": "PER", "PK": "PAK", "PH": "PHL", "PN": "PCN", "PL": "POL", "PM": "SPM", "ZM": "ZMB", "EH": "ESH", "EE": "EST", "EG": "EGY", "ZA": "ZAF", "EC": "ECU", "IT": "ITA", "VN": "VNM", "SB": "SLB", "ET": "ETH", "SO": "SOM", "ZW": "ZWE", "SA": "SAU", "ES": "ESP", "ER": "ERI", "ME": "MNE", "MD": "MDA", "MG": "MDG", "MF": "MAF", "MA": "MAR", "MC": "MCO", "UZ": "UZB", "MM": "MMR", "ML": "MLI", "MO": "MAC", "MN": "MNG", "MH": "MHL", "MK": "MKD", "MU": "MUS", "MT": "MLT", "MW": "MWI", "MV": "MDV", "MQ": "MTQ", "MP": "MNP", "MS": "MSR", "MR": "MRT", "IM": "IMN", "UG": "UGA", "TZ": "TZA", "MY": "MYS", "MX": "MEX", "IL": "ISR", "FR": "FRA", "IO": "IOT", "SH": "SHN", "FI": "FIN", "FJ": "FJI", "FK": "FLK", "FM": "FSM", "FO": "FRO", "NI": "NIC", "NL": "NLD", "NO": "NOR", "NA": "NAM", "VU": "VUT", "NC": "NCL", "NE": "NER", "NF": "NFK", "NG": "NGA", "NZ": "NZL", "NP": "NPL", "NR": "NRU", "NU": "NIU", "CK": "COK", "XK": "XKX", "CI": "CIV", "CH": "CHE", "CO": "COL", "CN": "CHN", "CM": "CMR", "CL": "CHL", "CC": "CCK", "CA": "CAN", "CG": "COG", "CF": "CAF", "CD": "COD", "CZ": "CZE", "CY": "CYP", "CX": "CXR", "CR": "CRI", "CW": "CUW", "CV": "CPV", "CU": "CUB", "SZ": "SWZ", "SY": "SYR", "SX": "SXM", "KG": "KGZ", "KE": "KEN", "SS": "SSD", "SR": "SUR", "KI": "KIR", "KH": "KHM", "KN": "KNA", "KM": "COM", "ST": "STP", "SK": "SVK", "KR": "KOR", "SI": "SVN", "KP": "PRK", "KW": "KWT", "SN": "SEN", "SM": "SMR", "SL": "SLE", "SC": "SYC", "KZ": "KAZ", "KY": "CYM", "SG": "SGP", "SE": "SWE", "SD": "SDN", "DO": "DOM", "DM": "DMA", "DJ": "DJI", "DK": "DNK", "VG": "VGB", "DE": "DEU", "YE": "YEM", "DZ": "DZA", "US": "USA", "UY": "URY", "YT": "MYT", "UM": "UMI", "LB": "LBN", "LC": "LCA", "LA": "LAO", "TV": "TUV", "TW": "TWN", "TT": "TTO", "TR": "TUR", "LK": "LKA", "LI": "LIE", "LV": "LVA", "TO": "TON", "LT": "LTU", "LU": "LUX", "LR": "LBR", "LS": "LSO", "TH": "THA", "TF": "ATF", "TG": "TGO", "TD": "TCD", "TC": "TCA", "LY": "LBY", "VA": "VAT", "VC": "VCT", "AE": "ARE", "AD": "AND", "AG": "ATG", "AF": "AFG", "AI": "AIA", "VI": "VIR", "IS": "ISL", "IR": "IRN", "AM": "ARM", "AL": "ALB", "AO": "AGO", "AQ": "ATA", "AS": "ASM", "AR": "ARG", "AU": "AUS", "AT": "AUT", "AW": "ABW", "IN": "IND", "AX": "ALA", "AZ": "AZE", "IE": "IRL", "ID": "IDN", "UA": "UKR", "QA": "QAT", "MZ": "MOZ"};

var countryCodes = {
    "BD": "Bangladesh",
    "BE": "Belgium",
    "BF": "Burkina Faso",
    "BG": "Bulgaria",
    "BA": "Bosnia and Herzegovina",
    "BB": "Barbados",
    "WF": "Wallis and Futuna",
    "BL": "Saint Barthelemy",
    "BM": "Bermuda",
    "BN": "Brunei",
    "BO": "Bolivia",
    "BH": "Bahrain",
    "BI": "Burundi",
    "BJ": "Benin",
    "BT": "Bhutan",
    "JM": "Jamaica",
    "BV": "Bouvet Island",
    "BW": "Botswana",
    "WS": "Samoa",
    "BQ": "Bonaire",
    "BR": "Brazil",
    "BS": "Bahamas",
    "JE": "Jersey",
    "BY": "Belarus",
    "BZ": "Belize",
    "RU": "Russia",
    "RW": "Rwanda",
    "RS": "Serbia",
    "TL": "East Timor",
    "RE": "Reunion",
    "TM": "Turkmenistan",
    "TJ": "Tajikistan",
    "RO": "Romania",
    "TK": "Tokelau",
    "GW": "Guinea-Bissau",
    "GU": "Guam",
    "GT": "Guatemala",
    "GS": "S'Georgia, S'Sandwich",
    "GR": "Greece",
    "GQ": "Equatorial Guinea",
    "GP": "Guadeloupe",
    "JP": "Japan",
    "GY": "Guyana",
    "GG": "Guernsey",
    "GF": "French Guiana",
    "GE": "Georgia",
    "GD": "Grenada",
    "GB": "United Kingdom",
    "GA": "Gabon",
    "SV": "El Salvador",
    "GN": "Guinea",
    "GM": "Gambia",
    "GL": "Greenland",
    "GI": "Gibraltar",
    "GH": "Ghana",
    "OM": "Oman",
    "TN": "Tunisia",
    "JO": "Jordan",
    "HR": "Croatia",
    "HT": "Haiti",
    "HU": "Hungary",
    "HK": "Hong Kong",
    "HN": "Honduras",
    "HM": "Heard & McDonald Islands",
    "VE": "Venezuela",
    "PR": "Puerto Rico",
    "PS": "Palestinian Territory",
    "PW": "Palau",
    "PT": "Portugal",
    "SJ": "Svalbard and Jan Mayen",
    "PY": "Paraguay",
    "IQ": "Iraq",
    "PA": "Panama",
    "PF": "French Polynesia",
    "PG": "Papua New Guinea",
    "PE": "Peru",
    "PK": "Pakistan",
    "PH": "Philippines",
    "PN": "Pitcairn",
    "PL": "Poland",
    "PM": "Saint Pierre & Miquelon",
    "ZM": "Zambia",
    "EH": "Western Sahara",
    "EE": "Estonia",
    "EG": "Egypt",
    "ZA": "South Africa",
    "EC": "Ecuador",
    "IT": "Italy",
    "VN": "Vietnam",
    "SB": "Solomon Islands",
    "ET": "Ethiopia",
    "SO": "Somalia",
    "ZW": "Zimbabwe",
    "SA": "Saudi Arabia",
    "ES": "Spain",
    "ER": "Eritrea",
    "ME": "Montenegro",
    "MD": "Moldova",
    "MG": "Madagascar",
    "MF": "Saint Martin",
    "MA": "Morocco",
    "MC": "Monaco",
    "UZ": "Uzbekistan",
    "MM": "Myanmar",
    "ML": "Mali",
    "MO": "Macao",
    "MN": "Mongolia",
    "MH": "Marshall Islands",
    "MK": "Macedonia",
    "MU": "Mauritius",
    "MT": "Malta",
    "MW": "Malawi",
    "MV": "Maldives",
    "MQ": "Martinique",
    "MP": "N'Mariana Islands",
    "MS": "Montserrat",
    "MR": "Mauritania",
    "IM": "Isle of Man",
    "UG": "Uganda",
    "TZ": "Tanzania",
    "MY": "Malaysia",
    "MX": "Mexico",
    "IL": "Israel",
    "FR": "France",
    "IO": "British Indian Ocean Territory",
    "SH": "Saint Helena",
    "FI": "Finland",
    "FJ": "Fiji",
    "FK": "Falkland Islands",
    "FM": "Micronesia",
    "FO": "Faroe Islands",
    "NI": "Nicaragua",
    "NL": "Netherlands",
    "NO": "Norway",
    "NA": "Namibia",
    "VU": "Vanuatu",
    "NC": "New Caledonia",
    "NE": "Niger",
    "NF": "Norfolk Island",
    "NG": "Nigeria",
    "NZ": "New Zealand",
    "NP": "Nepal",
    "NR": "Nauru",
    "NU": "Niue",
    "CK": "Cook Islands",
    "XK": "Kosovo",
    "CI": "Ivory Coast",
    "CH": "Switzerland",
    "CO": "Colombia",
    "CN": "China",
    "CM": "Cameroon",
    "CL": "Chile",
    "CC": "Cocos Islands",
    "CA": "Canada",
    "CG": "Republic of the Congo",
    "CF": "Central African Republic",
    "CD": "Dem' Rep' of the Congo",
    "CZ": "Czech Republic",
    "CY": "Cyprus",
    "CX": "Christmas Island",
    "CR": "Costa Rica",
    "CW": "Curacao",
    "CV": "Cape Verde",
    "CU": "Cuba",
    "SZ": "Swaziland",
    "SY": "Syria",
    "SX": "Sint Maarten",
    "KG": "Kyrgyzstan",
    "KE": "Kenya",
    "SS": "South Sudan",
    "SR": "Suriname",
    "KI": "Kiribati",
    "KH": "Cambodia",
    "KN": "Saint Kitts and Nevis",
    "KM": "Comoros",
    "ST": "Sao Tome and Principe",
    "SK": "Slovakia",
    "KR": "South Korea",
    "SI": "Slovenia",
    "KP": "North Korea",
    "KW": "Kuwait",
    "SN": "Senegal",
    "SM": "San Marino",
    "SL": "Sierra Leone",
    "SC": "Seychelles",
    "KZ": "Kazakhstan",
    "KY": "Cayman Islands",
    "SG": "Singapore",
    "SE": "Sweden",
    "SD": "Sudan",
    "DO": "Dominican Republic",
    "DM": "Dominica",
    "DJ": "Djibouti",
    "DK": "Denmark",
    "VG": "British Virgin Islands",
    "DE": "Germany",
    "YE": "Yemen",
    "DZ": "Algeria",
    "US": "United States",
    "UY": "Uruguay",
    "YT": "Mayotte",
    "UM": "US Minor Outlying Islands",
    "LB": "Lebanon",
    "LC": "Saint Lucia",
    "LA": "Laos",
    "TV": "Tuvalu",
    "TW": "Taiwan",
    "TT": "Trinidad and Tobago",
    "TR": "Turkey",
    "LK": "Sri Lanka",
    "LI": "Liechtenstein",
    "LV": "Latvia",
    "TO": "Tonga",
    "LT": "Lithuania",
    "LU": "Luxembourg",
    "LR": "Liberia",
    "LS": "Lesotho",
    "TH": "Thailand",
    "TF": "French S'Territories",
    "TG": "Togo",
    "TD": "Chad",
    "TC": "Turks and Caicos Islands",
    "LY": "Libya",
    "VA": "Vatican",
    "VC": "Saint Vincent & Grenadines",
    "AE": "United Arab Emirates",
    "AD": "Andorra",
    "AG": "Antigua and Barbuda",
    "AF": "Afghanistan",
    "AI": "Anguilla",
    "VI": "U.S. Virgin Islands",
    "IS": "Iceland",
    "IR": "Iran",
    "AM": "Armenia",
    "AL": "Albania",
    "AO": "Angola",
    "AQ": "Antarctica",
    "AS": "American Samoa",
    "AR": "Argentina",
    "AU": "Australia",
    "AT": "Austria",
    "AW": "Aruba",
    "IN": "India",
    "AX": "Aland Islands",
    "AZ": "Azerbaijan",
    "IE": "Ireland",
    "ID": "Indonesia",
    "UA": "Ukraine",
    "QA": "Qatar",
    "MZ": "Mozambique"
};



var clubColor = '#444';
var businessColor = '#cc9900';
var privateColor = '#357';
var nullColor = '#ccc';


function pieChart(clubInt, businessInt, privateInt, pColors) {
    colors = pColors;
    var data = [clubInt, businessInt, privateInt];
    var drawPieChart = function (data, colors) {
        var canvas = document.getElementById('pie');
        var ctx = canvas.getContext('2d');
        var x = canvas.width / 2,
                y = canvas.height / 2;
        var color,
                startAngle,
                endAngle,
                total = getTotal(data);

        for (var i = 0; i < data.length; i++) {
            color = colors[i];
            startAngle = calculateStart(data, i, total);
            endAngle = calculateEnd(data, i, total);
            ctx.beginPath();
            ctx.fillStyle = color;
            ctx.moveTo(x, y);
            ctx.arc(x, y, y - 5, startAngle, endAngle);
            ctx.fill();
        }
    };

    var getTotal = function (data) {
        var sum = 0;
        for (var i = 0; i < data.length; i++) {
            sum += data[i];
        }
        return sum;
    };

    var calculateStart = function (data, index, total) {
        if (index === 0) {
            return 0;
        }
        return calculateEnd(data, index - 1, total);
    };

    var calculateEndAngle = function (data, index, total) {
        var angle = data[index] / total * 360;
        var inc = (index === 0) ? 0 : calculateEndAngle(data, index - 1, total);
        return (angle + inc);
    };
    var calculateEnd = function (data, index, total) {
        return degreeToRadians(calculateEndAngle(data, index, total));
    };
    var degreeToRadians = function (angle) {
        return angle * Math.PI / 180
    }
    drawPieChart(data, colors);
}

function getCountryName() {
    if (document.getElementById('flagCountry') !== null) {
        var code = document.getElementById('flagImg').getAttribute('flag');
        document.getElementById('flagCountry').innerHTML = countryCodes[code];
    }
}


function search(pColors) {
    var finds = 0;
    var club = 0;
    var business = 0;
    var private = 0;
    var inputC = document.getElementById('countrySearch');
    var inputS = document.getElementById('nameSearch');
    filterC = inputC.value.toUpperCase();
    filterS = inputS.value.toUpperCase();
    var contacts = document.getElementById('innerListContainer');
    var aList = contacts.getElementsByClassName('listFlags');

    for (var i = 0; i < aList.length; i++) {
        var iso = aList[i].getAttribute('country');
        var cName = countryCodes[iso];
        var fName = aList[i].getAttribute('name');
        var lName = aList[i].getAttribute('lastname');


        if (cName.toUpperCase().indexOf(filterC) > -1 && (fName.toUpperCase().indexOf(filterS) > -1 || lName.toUpperCase().indexOf(filterS) > -1)) {
            aList[i].style.display = "block";
            var tempCat = aList[i].getAttribute('category');
            if (tempCat == 'club') {
                ;
                club++;
            } else if (tempCat == 'business') {
                ;
                business++;
            } else if (tempCat == 'private') {
                ;
                private++;
            }
            finds++;
        } else {
            aList[i].style.display = "none";
        }
    }
    GTotal = finds;
    GClub = club;
    GBusiness = business;
    GPrivate = private;
    //document.getElementById('selectAllData').innerHTML = finds;
    document.getElementById('selectClubData').innerHTML = club;
    document.getElementById('selectBusinessData').innerHTML = business;
    document.getElementById('selectPrivateData').innerHTML = private;
//    document.getElementById('selectCat1').style.opacity = "1";
//    document.getElementById('selectCat2').style.opacity = "1";
//    document.getElementById('selectCat3').style.opacity = "1";
//    document.getElementById('selectCat4').style.opacity = "1";
    var catData = document.getElementById('selectAllData');

    if (globalID === 'selectCat1') {
        catData.innerHTML = GTotal;
        pColors = [clubColor, businessColor, privateColor];
    } else if (globalID === 'selectCat2') {
        var perc = GClub / GTotal * 100;
        catData.innerHTML = perc.toFixed(1) + "%";
        for (var i = 0; i < aList.length; i++) {
            var category = aList[i].getAttribute('category');
            if (category === 'business' || category === 'private') {
                aList[i].style.display = "none";
            }
        }
        pColors = [clubColor, nullColor, nullColor];
    } else if (globalID === 'selectCat3') {
        var perc = GBusiness / GTotal * 100;
        catData.innerHTML = perc.toFixed(1) + "%";
        for (var i = 0; i < aList.length; i++) {
            var category = aList[i].getAttribute('category');
            if (category === 'club' || category === 'private') {
                aList[i].style.display = "none";
            }
        }
        pColors = [nullColor, businessColor, nullColor];
    } else if (globalID === 'selectCat4') {
        var perc = GPrivate / GTotal * 100;
        catData.innerHTML = perc.toFixed(1) + "%";
        for (var i = 0; i < aList.length; i++) {
            var category = aList[i].getAttribute('category');
            if (category === 'business' || category === 'club') {
                aList[i].style.display = "none";
            }
        }
        pColors = [nullColor, nullColor, privateColor];
    }

    pieChart(club, business, private, pColors);
}

function listFlags() {
    var contacts = document.getElementById('innerListContainer');
    if (contacts != null) {
        var aList = contacts.getElementsByClassName('listFlags');
        for (var i = 0; i < aList.length; i++) {
            var iso = aList[i].getAttribute('country');
            var span = document.createElement('div');
            var img = document.createElement('img');
            var cName = countryCodes[iso];
            span.innerHTML = "<span class='countryTag' style='white-space: nowrap;cursor:pointer;color:#444;position:absolute;right:55px;top:14px;text-align:right;width:auto;' onclick='addCountry(this.innerHTML)'>" + cName + "</span>";
            span.setAttribute("style", "position:absolute;right:10px;top:0;text-align:left;");
            img.setAttribute("src", "https://www.countryflags.io/" + iso + "/shiny/48.png");
            img.setAttribute("class", "IFlags");
            img.setAttribute("style", "position:absolute;right:0px;top:6px;");
            span.appendChild(img);
            aList[i].appendChild(span);
        }
    }
}
var globalID = 'selectCat1';
var GTotal, GClub, GBusiness, GPrivate;
function catButtons(id) {
    globalID = id;
    var contacts = document.getElementById('innerListContainer');
    if (contacts !== null) {
        var aList = contacts.getElementsByClassName('listFlags');
        var catDataLabel = document.getElementById('selectAll');
        var catData = document.getElementById('selectAllData');
        catDataLabel.innerHTML = "Percentage";
        if (id === 'selectCat1') {
            document.getElementById('selectCat1').style.opacity = "1";
            document.getElementById('selectCat2').style.opacity = "1";
            document.getElementById('selectCat3').style.opacity = "1";
            document.getElementById('selectCat4').style.opacity = "1";
            for (var i = 0; i < aList.length; i++) {
                aList[i].style.display = "block";
            }
            search([clubColor, businessColor, privateColor]);
            catDataLabel.innerHTML = "Total";
            document.getElementById('total').style.display = "none";
            catData.innerHTML = GTotal;
        } else if (id === 'selectCat2') {
            search([clubColor, nullColor, nullColor]);
            document.getElementById('selectCat1').style.opacity = "0.9";
            document.getElementById('selectCat2').style.opacity = "1";
            document.getElementById('selectCat3').style.opacity = "0.4";
            document.getElementById('selectCat4').style.opacity = "0.4";
            for (var i = 0; i < aList.length; i++) {
                var category = aList[i].getAttribute('category');
                if (category === 'business' || category === 'private') {
                    aList[i].style.display = "none";
                }
            }
            var perc = GClub / GTotal * 100;
            catData.innerHTML = perc.toFixed(1) + "%";
            document.getElementById('total').style.display = "block";
        } else if (id === 'selectCat3') {
            search([nullColor, businessColor, nullColor]);
            document.getElementById('selectCat1').style.opacity = "0.9";
            document.getElementById('selectCat2').style.opacity = "0.4";
            document.getElementById('selectCat3').style.opacity = "1";
            document.getElementById('selectCat4').style.opacity = "0.4";
            for (var i = 0; i < aList.length; i++) {
                var category = aList[i].getAttribute('category');
                if (category === 'club' || category === 'private') {
                    aList[i].style.display = "none";
                }
            }
            var perc = GBusiness / GTotal * 100;
            catData.innerHTML = perc.toFixed(1) + "%";
            document.getElementById('total').style.display = "block";

        } else if (id === 'selectCat4') {
            search([nullColor, nullColor, privateColor]);
            document.getElementById('selectCat1').style.opacity = "0.9";
            document.getElementById('selectCat2').style.opacity = "0.4";
            document.getElementById('selectCat3').style.opacity = "0.4";
            document.getElementById('selectCat4').style.opacity = "1";
            for (var i = 0; i < aList.length; i++) {
                var category = aList[i].getAttribute('category');
                if (category === 'business' || category === 'club') {
                    aList[i].style.display = "none";
                }
            }
            var perc = GPrivate / GTotal * 100;
            catData.innerHTML = perc.toFixed(1) + "%";
            document.getElementById('total').style.display = "block";

        }
    }
}

function addCountry(country) {
    //clear previous highlighting
    var svgCountries = document.getElementsByClassName("datamaps-subunit");
    for (var i = 0; i < svgCountries.length; i++) {
        svgCountries[i].style.fill = "rgb(80,80,80)";
    }

    document.getElementById('countrySearch').value = country;//input coutry into search box
    search([clubColor, businessColor, privateColor]);

    //change d3 map to highlight country passed in here
    //convert country string to alpha3 code
    var alpha2 = findKey(countryCodes, country);
    var alpha3 = iso2ToIso3[alpha2];
    //console.log(alpha2 +" "+ alpha3);
    //get class with alpha3 code
    var svgCountry = document.getElementsByClassName(alpha3)[0];
    console.log(svgCountry);
    //add new class with css changes to highlight
    svgCountry.style.fill = "green";

}

function findKey(dataObj, value) {// not my code
//finds key for a given value
    for (var key in dataObj) {
        if (dataObj.hasOwnProperty(key) && dataObj[key] === value) {
            return key;
        }
    }

    return false;

}//not my code

function clearSearch(pButton) {
    if (pButton === "country") {
        document.getElementById('countrySearch').value = "";
        search([clubColor, businessColor, privateColor]);
    } else {
        document.getElementById('nameSearch').value = "";
        search([clubColor, businessColor, privateColor]);
    }
}

function backButton() {
    history.back();
}
var infoOpen = false;
function toggleInfoDiv() {

    if (!infoOpen) {
        var infoCont = document.getElementById('info');

        infoCont.classList.add("infoWidthChange");
        setTimeout(() => {
            infoCont.classList.add("infoHeightChange");
            document.getElementById('close').style.opacity = "0.5";
        }, 500);
        infoOpen = true;
    } else {

        document.getElementById('close').style.opacity = "0";
        var infoCont = document.getElementById('info');
        infoCont.classList.remove("infoHeightChange");
        setTimeout(() => {
            infoCont.classList.remove("infoWidthChange");
        }, 500);
        infoOpen = false;
    }
}


