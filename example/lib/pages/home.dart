import 'package:example/models/name_model.dart';
import 'package:flutter/material.dart';
import 'package:flutter_svg/flutter_svg.dart';
import 'package:example/pages/home2.dart';

class HomePage extends StatelessWidget {
  HomePage({super.key});

  List<NameModel> names = [];

  //fill the name List
  void getNames() {
    names = NameModel.getNames();
  }

  @override
  Widget build(BuildContext context) {
    getNames();
    return Scaffold(
      backgroundColor: Color.fromARGB(255, 45, 45, 41),
      appBar: appBarMethod(),
      body: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          SizedBox(height: 20),
          Container(
            margin: EdgeInsets.all(10),
            padding: EdgeInsets.all(10),
            decoration: BoxDecoration(
              color: Color.fromARGB(255, 143, 220, 56),
              borderRadius: BorderRadius.circular(16),
            ),
            child: Row(
              children: [
                Image.asset(
                  'assets/anonim.png',
                  width: 60,
                  height: 60,
                ),
                SizedBox(width: 10),
                Column(
                  crossAxisAlignment: CrossAxisAlignment.start,
                  children: [
                    Text(
                      'Mate',
                      style: TextStyle(
                        fontSize: 16,
                        fontWeight: FontWeight.bold,
                      ),
                    ),
                    Text(
                      'System Integration Engineer Intern',
                      style: TextStyle(
                        fontSize: 14,
                      ),
                    ),
                  ],
                ),
              ],
            ),
          ),
          Padding(
            padding: const EdgeInsets.all(10.0),
            child: Text(
              'Epic squad:',
              style: TextStyle(
                color: Colors.white,
                fontSize: 18,
                fontWeight: FontWeight.w600,
              ),
            ),
          ),
          SizedBox(height: 0),
          Container(
            color: Color.fromARGB(255, 45, 45, 41),
            height: 120,
            child: ListView.builder(
              itemCount: names.length,
              scrollDirection: Axis.horizontal,
              itemBuilder: (context, index) {
                final nameModel = names[index];
                return Container(
                  width: 85,
                  margin: EdgeInsets.all(8),
                  decoration: BoxDecoration(
                    color: Color.fromARGB(255, 45, 45, 41),
                  ),
                  child: Column(
                    mainAxisAlignment: MainAxisAlignment.center,
                    children: [
                      Image.asset(
                        'assets/anonim.png',
                        width: 60,
                        height: 60,
                      ),
                      SizedBox(height: 8),
                      Text(
                        nameModel.name,
                        style: TextStyle(
                          color: Colors.white,
                        ),
                      ),
                    ],
                  ),
                );
              },
            ),
          ),
          Align(
            alignment: Alignment.bottomRight,
            child: Padding(
              padding: const EdgeInsets.all(10.0),
              child: Text(
                'Edit Squad',
                style: TextStyle(
                  color: Colors.white,
                  fontSize: 12,
                  fontWeight: FontWeight.w600,
                ),
              ),
            ),
          ),
        ],
      ),
      floatingActionButton: Container(
        width: 100, // Állítsd be a gomb szélességét igényeid szerint
        height: 100, // Állítsd be a gomb magasságát igényeid szerint
        decoration: BoxDecoration(
          shape: BoxShape.rectangle, // Négyzet alakú
          borderRadius: BorderRadius.circular(29.0), // Lekerekített szélek
          color: Color.fromARGB(255, 143, 220, 56),
          boxShadow: [
            BoxShadow(
              color: Colors.white, // Fehér árnyék szín
              blurRadius: 5.0, // Árnyék élessége
              spreadRadius: 0.05, // Árnyék terjedése
            ),
          ],
        ),
        child: FloatingActionButton(
          backgroundColor: Colors.transparent,
          onPressed: () {
//kattintás eseménykezelő
            Navigator.push(
              context,
              MaterialPageRoute(builder: (context) => HomePage2()),
            );
          },
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              Image.asset(
                'assets/key.jpg', // Az ikon elérési útja
                width: 40, // Kép szélessége
                height: 40, // Kép magassága
              ),
              Text(
                'Get Key', // A szöveg a FloatingActionButton alatt
                style: TextStyle(
                  fontSize: 15, // Igény szerint állítsd be a szöveg méretét
                  color: Colors.black, // Szöveg színe
                ),
              ),
            ],
          ),
        ),
      ),
    );
  }

  Container searchMethod() {
    return Container(
      margin: EdgeInsets.only(top: 40, left: 20, right: 20),
      decoration: BoxDecoration(boxShadow: [
        BoxShadow(color: Colors.black, blurRadius: 40, spreadRadius: 0.0)
      ]),
      child: TextField(
        decoration: InputDecoration(
            filled: true,
            border: OutlineInputBorder(
              borderRadius: BorderRadius.circular(15),
              borderSide: BorderSide.none,
            ),
            contentPadding: EdgeInsets.all(15)),
      ),
    );
  }

//clean class
  AppBar appBarMethod() {
    return AppBar(
      backgroundColor: Color.fromARGB(255, 45, 45, 41),
      elevation: 0,
      titleSpacing: 0, // Távolság a cím és a bal ikon között
      title: Padding(
        padding: EdgeInsets.only(left: 10), // Bal margó hozzáadása
        child: Row(
          mainAxisAlignment: MainAxisAlignment.start,
          children: [
            Image.asset(
              'assets/balKep.png',
              width: 30,
              height: 30,
            ),
            SizedBox(width: 8), // Margó az ikon és a szöveg között
            Text(
              'Home',
              style: TextStyle(
                color: Color.fromARGB(255, 251, 249, 249),
                fontSize: 18,
                fontWeight: FontWeight.bold,
              ),
            ),
          ],
        ),
      ),
    );
  }
}
