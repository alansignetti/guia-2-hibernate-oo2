package datos;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
public class Funciones {
		public static String traerFechaCorta(LocalDate fecha){
			
//			String fechaCorta = null;
//			fechaCorta=LocalDate.of(year);
			
//			fechaCorta.format(formatter)
//			LocalDate.		

			String fechaCorta = fecha.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG));
			fechaCorta = fecha.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT));
			
			return fechaCorta;
			
		}
}
