import 'package:flutter/material.dart';
import 'package:example/models/ticket_model.dart';

List<TicketModel> elements = [];

//fill the elements List
void getElements() {
  elements = TicketModel.getElements();
}

class HomePage2 extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    getElements();
    return Scaffold(
      backgroundColor: Color.fromARGB(255, 45, 45, 41),
      appBar: appBarMethod(),
      body: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
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
            padding: const EdgeInsets.fromLTRB(16, 8, 0, 0),
            child: Text(
              'Vehicle Reservations',
              style: TextStyle(
                color: Colors.white,
                fontSize: 16,
                fontWeight: FontWeight.w600,
              ),
            ),
          ),
          //ujjj CONTENEEER
          SizedBox(height: 20),
          Container(
            margin:
                EdgeInsets.fromLTRB(60, 10, 10, 10), // Balról 60px-re eltolva
            padding: EdgeInsets.all(10),
            decoration: BoxDecoration(
              color: Color.fromARGB(255, 45, 45, 41),
              borderRadius: BorderRadius.circular(16),
              boxShadow: [
                // Fehér árnyék
                BoxShadow(
                  color: Colors.white,
                  blurRadius: 5.0,
                  spreadRadius: 5.0,
                ),
              ],
            ),
            height: 100, // Állítsd be a magasságot igényeidnek megfelelően
            child: Row(
              children: [
                SizedBox(width: 10),
                Expanded(
                  child: ElevatedButton(
                    onPressed: () {
                      // Az első gomb eseménykezelője
                    },
                    style: ElevatedButton.styleFrom(
                      primary: Color.fromARGB(255, 45, 45, 41), // Fekete háttér
                      onPrimary:
                          Color.fromARGB(255, 143, 220, 56), // Zöld szöveg
                      shape: RoundedRectangleBorder(
                        borderRadius:
                            BorderRadius.circular(16), // Lekerekített szélek
                        side: BorderSide(
                          color:
                              Color.fromARGB(255, 143, 220, 56), // Zöld keret
                        ),
                      ),
                      minimumSize: Size(80, 80), // Méret beállítása
                    ),
                    child: Padding(
                      padding:
                          const EdgeInsets.all(0.0), // Belső margók beállítása
                      child: Column(
                        mainAxisAlignment: MainAxisAlignment.center,
                        children: [
                          Text(
                            'NEVADA',
                            style: TextStyle(
                              fontSize: 12,
                              letterSpacing: 2.0, // Betűköz beállítása
                            ),
                          ),
                          SizedBox(height: 20),
                          Text(
                            'Expires on:',
                            style: TextStyle(
                              fontSize: 10, // Kisebb betűméret
                              color: Color.fromARGB(105, 143, 220, 56),
                            ),
                          ),
                          Text(
                            'Aug-21 - 07:17',
                            style: TextStyle(
                              fontSize: 9,
                              letterSpacing: 2.0, // Betűköz beállítása
                              color: Color.fromARGB(105, 143, 220, 56),
                            ),
                          ),
                        ],
                      ),
                    ),
                  ),
                ),
                SizedBox(width: 10),
                Expanded(
                  child: ElevatedButton(
                    onPressed: () {
                      // A második gomb eseménykezelője
                    },
                    style: ElevatedButton.styleFrom(
                      primary: Color.fromARGB(255, 45, 45, 41), // Fekete háttér
                      onPrimary:
                          Color.fromARGB(255, 143, 220, 56), // Zöld szöveg
                      shape: RoundedRectangleBorder(
                        borderRadius:
                            BorderRadius.circular(16), // Lekerekített szélek
                        side: BorderSide(
                          color:
                              Color.fromARGB(255, 143, 220, 56), // Zöld keret
                        ),
                      ),
                      minimumSize: Size(80, 80), // Méret beállítása
                    ),
                    child: Column(
                      mainAxisAlignment: MainAxisAlignment.center,
                      children: [
                        Text(
                          'Reserve',
                          style: TextStyle(fontSize: 12),
                        ),
                        Text(
                          'Vehicle',
                          style: TextStyle(fontSize: 12),
                        ),
                        SizedBox(height: 10),
                        Image.asset('assets/plus.png', width: 24, height: 24),
                      ],
                    ),
                  ),
                ),
              ],
            ),
          ),
          //KOVIIIII
          SizedBox(height: 10),
          Container(
            margin: EdgeInsets.all(10),
            height: 50,
            width: 500,
            decoration: BoxDecoration(
              color: Color.fromARGB(255, 143, 220, 56), // Zöld szöveg
              borderRadius: BorderRadius.circular(56), // Lekerekített szélek
            ),
            child: ElevatedButton(
              onPressed: () {
                // Gombra kattintás eseménykezelő
              },
              style: ElevatedButton.styleFrom(
                backgroundColor:
                    Color.fromARGB(255, 143, 220, 56), // Zöld szöveg

                onPrimary: Colors.black,
                shape: RoundedRectangleBorder(
                  borderRadius:
                      BorderRadius.circular(16), // Lekerekített szélek
                ),
              ),
              child: Text(
                'See all vehicles at iaMotive HQ',
                style: TextStyle(
                  fontSize: 16, // Betűméret
                ),
              ),
            ),
          ),

          Padding(
            padding: EdgeInsets.all(10),
            child: Row(
              mainAxisAlignment: MainAxisAlignment.spaceBetween,
              children: [
                Text(
                  'Browse Jira',
                  style: TextStyle(
                    color: Colors.white,
                    fontSize: 16,
                    fontWeight: FontWeight.bold,
                  ),
                ),
                Row(
                  children: [
                    Image.asset('assets/reverse.jpg', width: 30, height: 30),
                    SizedBox(width: 10),
                    Image.asset('assets/car.png', width: 30, height: 30),
                    SizedBox(width: 10),
                    Image.asset('assets/filter.png', width: 30, height: 30),
                    SizedBox(width: 10),
                    Image.asset('assets/filter2.png', width: 30, height: 30),
                  ],
                ),
              ],
            ),
          ),
          Padding(
            padding: EdgeInsets.all(10.0),
            child: Row(
              mainAxisAlignment: MainAxisAlignment.spaceBetween,
              children: [
                Text(
                  'Assigned to me',
                  textAlign: TextAlign.left,
                  style: TextStyle(fontSize: 16.0, color: Colors.white),
                ),
                Row(
                  children: [
                    Text(
                      '9 tickets found',
                      textAlign: TextAlign.right,
                      style: TextStyle(fontSize: 16.0),
                    ),
                    SizedBox(
                        width: 10.0), // Köztes tér a kép és a szöveg között
                    Image.asset('assets/up.png', width: 24.0, height: 24.0),
                  ],
                ),
              ],
            ),
          ),
          //koviiiiiiiiiiiiiiii

          Container(
            color: Color.fromARGB(255, 45, 45, 41),
            height: 240,
            child: ListView.builder(
              itemCount: elements.length,
              scrollDirection: Axis.horizontal,
              itemBuilder: (context, index) {
                final ticket = elements[index];
                return Container(
                  width: 120,
                  margin: EdgeInsets.all(8),
                  decoration: BoxDecoration(
                    color: Color.fromARGB(255, 45, 45, 41),
                    borderRadius:
                        BorderRadius.circular(10), // Lekerekített sarkok
                  ),
                  child: Column(
                    mainAxisAlignment: MainAxisAlignment.center,
                    children: [
                      Container(
                        padding: EdgeInsets.all(8),
                        decoration: BoxDecoration(
                          color: Colors.white,
                          borderRadius:
                              BorderRadius.circular(10), // Lekerekített sarkok
                        ),
                        child: Text(
                          ticket.tag,
                          style: TextStyle(
                            color: Colors.black,
                          ),
                        ),
                      ),
                      SizedBox(height: 8),
                      Container(
                        padding: EdgeInsets.all(8),
                        decoration: BoxDecoration(
                          color: Colors.blue,
                          borderRadius:
                              BorderRadius.circular(10), // Lekerekített sarkok
                        ),
                        child: Text(
                          ticket.progress,
                          style: TextStyle(
                            color: Colors.white,
                          ),
                        ),
                      ),
                      SizedBox(height: 8),
                      Container(
                        padding: EdgeInsets.all(8),
                        decoration: BoxDecoration(
                          color: Colors.white,
                          borderRadius:
                              BorderRadius.circular(10), // Lekerekített sarkok
                        ),
                        child: Text(
                          ticket.desc,
                          style: TextStyle(
                            color: Colors.black,
                          ),
                        ),
                      ),
                    ],
                  ),
                );
              },
            ),
          ),
        ],
      ),
    );
  }

  AppBar appBarMethod() {
    return AppBar(
      backgroundColor: Color.fromARGB(255, 45, 45, 41),
      elevation: 0,
      title: Row(
        mainAxisAlignment: MainAxisAlignment.spaceBetween,
        children: [
          Padding(
            padding: const EdgeInsets.only(left: 16.0),
            child: Text(
              'Good morning',
              style: TextStyle(
                color: Colors.white,
                fontSize: 16,
                fontWeight: FontWeight.bold,
              ),
            ),
          ),
          Row(
            children: [
              Image.asset(
                'assets/bell.jpg',
                width: 30,
                height: 30,
              ),
              SizedBox(width: 16),
              Image.asset(
                'assets/settings.png',
                width: 30,
                height: 30,
              ),
            ],
          ),
        ],
      ),
    );
  }
}
