<div class="navbar navbar-default">
    <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-responsive-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="#">Puertos Callao</a>
    </div>
    <div class="navbar-collapse collapse navbar-responsive-collapse">
        <ul class="nav navbar-nav">
            <li class="active"><a href="<%=request.getContextPath()%>/barco/listBarcos.htm">Barcos</a></li>
            <li><a href="<%=request.getContextPath()%>/contenedor/listContenedores.htm">Contenedores</a></li>
            <li><a href="<%=request.getContextPath()%>/partida/listPartidas.htm">Partidas</a></li>
            <li><a href="<%=request.getContextPath()%>/arribo/listArribos.htm">Arribos</a></li>
            <li><a href="<%=request.getContextPath()%>/reporte/reporte.htm">Reportes</a></li>
            <li ><a href="<%=request.getContextPath()%>/profiling/listProfiling.htm">Profiling</a></li>
        </ul>
    </div>
</div>
