package com.ucaldas.aplicacion1

data class Nombres(
    val id: Int,
    val nombre: String,
    val imagenUrl: String,
    val descripcion: String,
    val superPoderes: List<String>
)

val listaNombres = listOf(
    Nombres(
        1, "Superman",
        "https://cdn.jsdelivr.net/gh/akabab/superhero-api@0.3.0/api/images/lg/644-superman.jpg",
        "El último hijo de Krypton protege la Tierra gracias a sus extraordinarias habilidades y su firme sentido de la justicia.",
        listOf("Inteligencia superior", "Super fuerza", "Super velocidad", "Alta resistencia", "Vuelo", "Visión calorífica")
    ),
    Nombres(
        2, "Batman",
        "https://cdn.jsdelivr.net/gh/akabab/superhero-api@0.3.0/api/images/lg/70-batman.jpg",
        "El Caballero de la Noche utiliza su intelecto, entrenamiento y tecnología para defender Gotham City.",
        listOf("Inteligencia", "Combate", "Sigilo", "Estrategia", "Tecnología")
    ),
    Nombres(
        3, "Wonder Woman",
        "https://cdn.jsdelivr.net/gh/akabab/superhero-api@0.3.0/api/images/lg/720-wonder-woman.jpg",
        "Princesa amazona y defensora de la paz, combina fuerza, velocidad y una gran habilidad de combate.",
        listOf("Super fuerza", "Velocidad", "Combate", "Resistencia", "Vuelo")
    ),
    Nombres(
        4, "Spider-Man",
        "https://cdn.jsdelivr.net/gh/akabab/superhero-api@0.3.0/api/images/lg/620-spider-man.jpg",
        "Peter Parker usa sus reflejos, sentido arácnido y telarañas para ayudar a quienes lo necesitan.",
        listOf("Agilidad", "Sentido arácnido", "Trepar muros", "Inteligencia", "Telarañas")
    ),
    Nombres(
        5, "Iron Man",
        "https://cdn.jsdelivr.net/gh/akabab/superhero-api@0.3.0/api/images/lg/346-iron-man.jpg",
        "Tony Stark es un inventor brillante que combate el peligro con armaduras tecnológicamente avanzadas.",
        listOf("Inteligencia", "Tecnología", "Vuelo", "Armas de energía", "Estrategia")
    ),
    Nombres(
        6, "The Flash",
        "https://cdn.jsdelivr.net/gh/akabab/superhero-api@0.3.0/api/images/lg/263-flash.jpg",
        "El velocista escarlata puede moverse a velocidades extraordinarias y reaccionar en fracciones de segundo.",
        listOf("Super velocidad", "Reflejos", "Viaje temporal", "Vibración", "Resistencia")
    ),
    Nombres(
        7, "Captain America",
        "https://cdn.jsdelivr.net/gh/akabab/superhero-api@0.3.0/api/images/lg/149-captain-america.jpg",
        "Steve Rogers es un líder heroico con condición física excepcional, disciplina y un fuerte compromiso con su equipo.",
        listOf("Fuerza mejorada", "Liderazgo", "Combate", "Estrategia", "Resistencia")
    ),
    Nombres(
        8, "Thor",
        "https://cdn.jsdelivr.net/gh/akabab/superhero-api@0.3.0/api/images/lg/659-thor.jpg",
        "El dios del trueno protege los Nueve Reinos y canaliza poderosas energías a través de su martillo.",
        listOf("Control del rayo", "Super fuerza", "Vuelo", "Resistencia", "Energía")
    )
)



val listaVillanos = listOf(
    Nombres(101, "Joker",
        "https://cdn.jsdelivr.net/gh/akabab/superhero-api@0.3.0/api/images/lg/370-joker.jpg",
        "El príncipe payaso del crimen convierte Gotham en un escenario de caos y demuestra ser uno de los enemigos más impredecibles de Batman.",
        listOf("Genio criminal", "Manipulación", "Química", "Trampas", "Impredecibilidad")),
    Nombres(102, "Lex Luthor",
        "https://images.openai.com/static-rsc-4/OGj1MZb_iPPdBckn8bhDwVbBnXLujGYRPKh4Sr2mQ3sNJm6CV3wVYXoez3NCOuFXb1gKEUfahAIVO8iQFT1hq0UA3NW0wOOMw2PGcP_oK8-DSZoEOvhLejpu71dl8vt2qYPRssOkm8yLzQD528xhp_EoMeOlZE3hvxPVmYyzFFrt5F6EuZEuyw6pnxz7cjCa?purpose=fullsize",
        "Magnate y científico brillante, utiliza su intelecto, recursos y poder político para intentar derrotar a Superman.",
        listOf("Intelecto genial", "Tecnología", "Estrategia", "Recursos ilimitados", "Armadura de combate")),
    Nombres(103, "Thanos",
        "https://cdn.jsdelivr.net/gh/akabab/superhero-api@0.3.0/api/images/lg/655-thanos.jpg",
        "El titán busca imponer su visión de equilibrio universal, dispuesto a enfrentarse a civilizaciones enteras para lograrlo.",
        listOf("Super fuerza", "Resistencia", "Estrategia", "Combate", "Poder cósmico")),
    Nombres(104, "Loki",
        "https://images.openai.com/static-rsc-4/f0f4ypV13pIT5pkqBH_s6jn9zMXHYGEg47l_rMCVWiqATIJLhLS8BKrw79XW887Vh9KNkZH22-enNr9oiuR3Y5bTnn-cRXW8be5EpZvuUU9kPgNJs9DY9m5mUr5HjfpBea90_c6YUZQHmSF6hdaIpDSCmIhcqjBblk7U5WRDGvqTONLkofok3v56wMDod_Ct?purpose=fullsize",
        "Dios de las mentiras y maestro del engaño, recurre a la magia y la manipulación para conseguir sus objetivos.",
        listOf("Magia", "Ilusiones", "Cambios de forma", "Manipulación", "Longevidad")),
    Nombres(105, "Green Goblin",
        "https://images.openai.com/static-rsc-4/7m5H4vvxW1VjFmankMNDOSI2-fneOJCA56QcXhk3jhQf3BZUcSPJdwe8Dhk14YnCxTVim22WP87tBnlDqRx-qrV2xGInumz8P_8IMpeu_z0XA2H1Vc0AW75jYea4-83YtoerhvHJ6UTXmd4w0TrAt4NQgsWvJxU0k-2K0BlrDQg?purpose=inline",
        "Norman Osborn combina una mente empresarial peligrosa con tecnología avanzada y una identidad criminal obsesionada con Spider-Man.",
        listOf("Fuerza mejorada", "Intelecto", "Planeador", "Bombas", "Agilidad")),
    Nombres(106, "Venom",
        "https://cdn.jsdelivr.net/gh/akabab/superhero-api@0.3.0/api/images/lg/687-venom.jpg",
        "Un simbionte alienígena unido a Eddie Brock crea una criatura poderosa, feroz y de moral cambiante.",
        listOf("Fuerza sobrehumana", "Regeneración", "Camuflaje", "Telarañas", "Adherencia")),
    Nombres(107, "Magneto",
        "https://cdn.jsdelivr.net/gh/akabab/superhero-api@0.3.0/api/images/lg/423-magneto.jpg",
        "Mutante capaz de controlar los campos magnéticos; lucha por la supervivencia de los mutantes, incluso mediante métodos extremos.",
        listOf("Magnetismo", "Campos de fuerza", "Vuelo", "Manipulación metálica", "Estrategia")),
    Nombres(108, "Darkseid",
        "https://cdn.jsdelivr.net/gh/akabab/superhero-api@0.3.0/api/images/lg/204-darkseid.jpg",
        "Tirano de Apokolips, busca someter toda vida libre y encontrar la Ecuación Anti-Vida para dominar el universo.",
        listOf("Fuerza divina", "Rayos Omega", "Teletransportación", "Resistencia", "Conquista"))
)
