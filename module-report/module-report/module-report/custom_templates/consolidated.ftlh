<#function to_id text>
    <#return text?lower_case?replace("[^a-z0-9]", "-", "r")>
</#function>
<!DOCTYPE html>
<html>
<head xmlns="http://www.w3.org/1999/xhtml">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <style type="text/css">
        .collapsible {
            background-color: #e2feba;
            color: white;
            cursor: pointer;
            padding: 10px;
            width: 100%;
            text-align: left;
            outline: #e2feba;
            font-size: 15px;
            font-weight: bold;
            transition: max-height 10s ease-out;
            border-radius: 8px;
            box-shadow: 0 12px 16px 0 rgba(0, 0, 0, 0.24), 0 17px 50px 0 rgba(0, 0, 0, 0.19);
            -webkit-transition-duration: 0.4s; /* Safari */
            transition-duration: 0.4s;
        }

        .active, .collapsible:hover {
            background-color: #e2feba;
            font-size: 15.5px;
        }

        .collapsible:after {
            content: '\002B';
            color: black;
            font-weight: bold;
            float: right;
            margin-left: 5px;
        }

        .active:after {
            content: "\2212";
        }

        .contents {
            padding: 0 18px;
            max-height: 0;
            overflow: hidden;
            transition: max-height 0.2s ease-out;
            width: 100%;
        }

        html, body, h1, h2, h3, h4, h5, h6 {
            background: #ffffff; /* Old browsers */
            font-family: "Arial", sans-serif;
        }

        h1 {
            margin-top: 50px;
            color: white;
            padding-left: 10px;
            background: #74bbd9; /* Old browsers */
             background: -moz-linear-gradient(top,  #00915A 0%, #00A071 50%, #00AC7D 35%, #00915A 100%); /* FF3.6-15 */
            background: -webkit-linear-gradient(top,  #00915A 0%, #00A071 50%, #00AC7D 35%, #00915A 100%); /* Chrome10-25,Safari5.1-6 */
            background: linear-gradient(to bottom,  #00915A 0%, #00A071 50%, #00AC7D 35%, #00915A 100%); /* W3C, IE10+, FF16+, Chrome26+, Opera12+, Safari7+ */
            filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#74bbd9', endColorstr='#44a4cb', GradientType=0); /* IE6-9 */
            font-weight: normal;
            font-size: larger;
            height: 50px;
            line-height: 50px;

        }

        h2 {
            color: white;
            padding-left: 10px;
            background: #49c0f0; /* Old browsers */
            background: -moz-linear-gradient(top, #045545 50%, #045545 100%); /* FF3.6-15 */
            background: -webkit-linear-gradient(top, #045545 50%, #045545 100%); /* Chrome10-25,Safari5.1-6 */
            background: linear-gradient(to bottom, #045545 50%, #045545 100%); /* W3C, IE10+, FF16+, Chrome26+, Opera12+, Safari7+ */
            filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#49c0f0', endColorstr='#2cafe3', GradientType=0); /* IE6-9 */
            font-size: large;
            height: 30px;
            line-height: 30px;
            font-weight: normal;
            margin-top: 20px;
            margin-bottom: 2px;

        }

        h3 {
            background-color: #f1f4e7
        }

        th {
            border: 2px solid #cddfe4;
            background: #74bbd9; /* Old browsers */
            background: -moz-linear-gradient(top, #00AC7D 50%, #00A071 100%); /* FF3.6-15 */
            background: -webkit-linear-gradient(top, #00ab8f 50%, #00ab8f 100%); /* Chrome10-25,Safari5.1-6 */
            background: linear-gradient(to bottom, #00ab8f 50%, #00ab8f 100%); /* W3C, IE10+, FF16+, Chrome26+, Opera12+, Safari7+ */
            filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#74bbd9', endColorstr='#44a4cb', GradientType=0); /* IE6-9 */
            color: white;
            height: 30px;
            line-height: 30px;
            font-weight: normal;
        }

        td {
            border: 1px solid #cddfe4;
            padding: 5px;

        }

        tr {
            color: #090080d6;
            font-weight: bold;
        }

        table, tr, td, th {
            border-collapse: collapse;
        }

        table {
            border: 1px solid #cddfe4;
            border-collapse: collapse;
            width: 100%;
        }

        span a {
            color: black;
        }

        span a:hover {
            font-weight: bold;
            color: #0000ff;
        }


        a {
            color: #D2691E
        }

        b {
            color: #0000ff;
        }

        .chart {
            border: 1px solid #cddfe4;
            border-collapse: collapse;
            background-color: transparent;
        }

        .passed {
            background-color: transparent;
            font-weight: normal;
            color: forestgreen;
            /*border: 1px solid green;*/
        }

        .skipped {
            background-color: silver;
            font-weight: bold;
            color: darkgray
        }

        .failed {
            background-color: white;
            font-weight: normal;
            color: red;
            border: 1px solid red;

        }

        .undefined {
            background-color: white;
            font-weight: bold;
            color: goldenrod
        }

        .lowest {
            background-color: lightyellow;
            color: black
        }

        .low {
            background-color: gold;
            color: black
        }

        .medium {
            background-color: orange;
            color: black
        }

        .high {
            background-color: orangered;
            color: black
        }

        .highest {
            background-color: darkred;
            color: black
        }

        .passed_description {
            background-color: #D0FFD0;
            font-weight: bold;
            font-style: italic;
            color: black
        }

        .failed_description {
            background-color: #FFA898;
            font-weight: bold;
            font-style: italic;
            color: black
        }

        .noborder {
            border: transparent;
            border-collapse: collapse;
            vertical-align: top;
        }

        span.passed {
            border: 0px transparent;
        }

        a.failed {
            color: red;
        }

        span.failed {
            animation: blinker 2s linear infinite;
        }

        @keyframes blinker {
            50% {
                opacity: 0;
            }
        }

        OL {
            counter-reset: item
        }

        OL > LI {
            display: block
        }

        OL > LI:before {
            content: counters(item, ".") " ";
            counter-increment: item
        }

        div.header {
            display: block;
            text-align: center;
            position: running(header);
        }

        div.footer {
            display: block;
            text-align: center;
            position: running(footer);
        }

        div.content {
            page-break-after: always;
        }

        div.content:last-child {
            page-break-after: avoid;
        }

        a {
            color: #D2691E
        }

        b {
            color: #0000FF;
        }

        .a1 {
            color: #333333;
            text-decoration: transparent;
        }

        @page {
            size: A4 landscape;
            @top-center {
                content: "Overall Results";
                color: silver;
                font-size: 14px;
            }
            @top-right {
                /*content: date("dd MMM, yyyy hh:mm");*/
                color: silver;
                font-size: 8px;
            }
            @bottom-right {
                content: "Page " counter(page) " of " counter(pages) ;
                color: silver;
                font-size: 8px;
            }
        }

        ol a::after {
            content: leader('.') target-counter(attr(href url), page);
        }
    </style>
    ${refreshData}
    <title>${title}</title>
    <meta charset="UTF-8"/>
</head>
<body>
<div class='header'>
<table>
<tr><p style="color:white; font-size: 1px;">.</p></tr>
<tr><p style="color:white; font-size: 1px;">.</p></tr>
<tr><p style="color:white; font-size: 1px;">.</p></tr>
<tr><p style="color:white; font-size: 1px;">.</p></tr>
<tr><p style="color:white; font-size: 1px;">.</p></tr>
<tr><p style="color:white; font-size: 1px;">.</p></tr>
<tr><p style="color:white; font-size: 1px;">.</p></tr>
</table>
<image src="C:\Bitbucket\rta\module-report\module-report\module-report\custom_templates\BNP_Logo.png" alt="BNPP Logo" align= "left"/>
</div>
<div class='footer'></div>
<#if useTableOfContents>
    <h1>Table of Contents</h1>
    <ol>
        <#list contents?keys as section_name>
            <li><a href="#${to_id(section_name)}">${section_name}</a></li>
        </#list>
    </ol>
</#if>
<table class="noborder">
    <#assign index=0>
    <#list contents?keys as section_name>
        <#if index % columns == 0>
            <tr class="noborder" valign="top">
        </#if>
        <td class="noborder">
            <div class="content"><a id="${to_id(section_name)}"><h1>${section_name}</h1></a>
                ${contents[section_name]}
            </div>
        </td>
        <#if index % columns == (columns - 1)>
            </tr>
        </#if>
        <#assign index++>
    </#list>
    <#if index % columns != 0>
        </tr>
    </#if>
</table>
</body>
</html>