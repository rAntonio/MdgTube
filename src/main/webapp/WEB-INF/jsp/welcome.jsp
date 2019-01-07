<%-- 
    Document   : welcome
    Created on : 5 janv. 2019, 11:10:03
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width , initial-scale=1.0">
        <title>Gasy Tube</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/bootstrap.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/fontawesome-all.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/styles.css">
   
    </head>
    <body>
                  
            <!-- CORE -->
            
                <div class="col-md-12  core">
                    <div class="row">
                        <!-- MENU LATERALE -->
                            <div class="col-2 core-menu-laterale">
                                    
                                            <!-- LOGO -->
                                                <div class="col-12  core-logo">
                                                    <img src="${pageContext.request.contextPath}/resources/logo.png" style="width: 200px;height: 200px;margin-top: -69px;" alt="gasy tube">
                                                </div>
                                            <!-- LOGO -->
                                            <hr/>
                                            <!-- MENU -->
                                                <div class="col-12 core-menu" style="font-size: 20px;">
                                                        <div class="row">
                                                            <ul class="col-12">
                                                                <a href="#" ><li class="activer" >Accueil</li></a>
                                                                <a href="#" ><li>Recherche</li></a>
                                                                <hr/>
                                                                 <a href="#" ><li>playlist-1</li></a>
                                                                 <a href="#" ><li>playlist-2</li></a>
                                                                 <a href="#" ><li>playlist-3</li></a>
                                                                <hr/>
                                                                <a href="#" ><li>Sign out</li></a>
                                                                 
                                                            </ul>
                                                        </div>
                                                      
                                                </div>
                                            <!-- MENU -->
                                            <!-- COMPTE -->
                                                <div class="col-12 core-compte">
                
                                                </div>
                                            <!-- COMPTE -->
                                                
                                    
                                </div>
                    <!-- MENU LATERALE -->
                    <!-- LISTE -->
                        <div class="col-10 offset-2 core-liste">
                            <div class="row">
                                <!-- MENU PLAYLiST-->
                                    <div class="col-9 offset-2 core-liste-menu">
                                        <div class="row">
                                              <ul class="col-md-12">
                                                  <a href=""><li class="col-4"> Ã LA UNE </li></a>
                                                  <a href=""><li class="col-3 ActiverTop"> PODCAST </li></a>
                                                  <a href=""><li class="col-4"> NOUVEAUTES </li></a>
                                             </ul>
                                       </div>
                                    </div>
                                <!-- MENU PLAYLiST-->
                                <!-- LISTE MUSIC -->
                                    <div class="col-12 core-liste-music">
                                            
                                            <div class="row">
                                                    <div class="col-12  core-categories">
                                                        <h1>Populaire</h1>
                                                        <div class="row">
                                                            <% for(int i=0;i<10;i++){ %>
                                                            <div class="col-2 core-categories-liste" style=" background-image: url('${pageContext.request.contextPath}/resources/assets/images/default2.png');">
                                                                <h5>titre</h5>
                                                            </div>
                                                            <% } %>
                                                        </div>
                                                        <hr/>
                                                        <h1>Artiste</h1>
                                                            <div class="row">
                                                                <% for(int i=0;i<10;i++){ %>
                                                                <div class="col-2 core-categories-liste"></div>
                                                                <% } %>
                                                            </div>
                                                        <hr/>
                                                        <h1>Album</h1>
                                                        <div class="row">
                                                             <% for(int i=0;i<10;i++){ %>
                                                            <div class="col-2 core-categories-liste"><h5 style="margin-top: 100%;">Album name</h5></div>
                                                            <% } %>
                                                        </div>
                                                    </div>
                                        </div>

                                            
                                    </div>
                                <!-- LISTE MUSIC -->
                             </div>
                        </div>
                    <!-- LISTE -->
                    </div>
                </div>
               
            <!-- CORE -->
            <!-- MEDIA PLAYER-->
                <div class="col-md-12 player">
                    <div class="row">
                            <div class="col-md-10 offset-md-2 equalizer">
                            </div>
                            <div class="col-md-3 offset-md-1 musique">
                                <div class="row">
                                    <div id="previous"></div>
                                    <div id="play"></div>
                                    <div id="forward"></div>
                                </div>
                            </div>
                            <div id="playlist" class="col-md-8">

                                <div id="track-details" title="Show playlist">
                                    <i class="fa fa-sort"></i>
                                    <p id="track-desc">There are no tracks loaded in the player.</p>
                                    <p id="track-time">
                                        <span id="current">-</span> / <span id="total">-</span>
                                    </p>
                                </div>
                    
                                <div id="expand-bar" class="hidden">               
                                    <ul id="list"></ul>
                                </div>
                    
                            </div>
                    </div>
                </div>
            <!-- MEDIA PLAYER -->
        <script src="${pageContext.request.contextPath}/resources/assets/js/jquery-3.3.1.js"></script>
        <script src="${pageContext.request.contextPath}/resources/assets/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/assets/js/fontawesome.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/assets/js/anime.js"></script>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/stylesEqualizer.css">
    </body>
        
</html>
