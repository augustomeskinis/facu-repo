program ej4p3;
type
	regFlor = record
		nombre: String[45];
		codigo: integer;
	end;
	
	
	archivoFlores = file of regFlor;
	
var
	ar:archivoFlores;
	f,cabecera:regFlor;
	
	
procedure agregarFlor(nombre:string;codigo:integer);
var
	posFinal,posEliminado:integer;
begin
	reset(ar);
	read(ar,cabecera);
	if(cabecera.codigo=0)then begin
		f.nombre:= nombre;
		f.codigo:= codigo;
		posFinal:= fileSize(ar)-1;
		seek(ar,posFinal);
		write(ar,f);
	end;
	else begin
		posEliminado:= cabecera.codigo * (-1);
		seek(ar,posEliminado);
		read(ar,f);
		cabecera.codigo:=f.codigo;
		f.codigo:= codigo;
		f.nombre:= nombre;
		seek(ar,posEliminado);
		write(ar,f);
		seek(ar,0);
		write(ar,cabecera);
	end;
	close(ar);
end;

var
	codLeido:integer;
	nombreLeido:string;


begin
	assign(ar,'archivoFlores');
	rewrite(ar);
	cabecera.codigo:=0;
	write(ar,cabecera);
	close(ar);
	writeln('	ingrese el codigo de  la flor a agregar: 	');
	readln(codLeido);
	writeln('	ingrese el codigo de  la flor a agregar: 	');
	readln(nombreLeido);
	agregarFlor(nombreLeido,codLeido);
	
