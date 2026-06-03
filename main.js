(function($) {
        $(document).ready(function() {
            function adBlockNotDetected() {}
            function adBlockDetected() {
                $(".ab-detected").removeClass("hide"),
                    $("body").addClass("ab-detected")
            }
            myBlockAdBlock = new BlockAdBlock({
                checkOnLoad: !0,
                resetOnEnd: !0
            }),
                "undefined" == typeof blockAdBlock ? adBlockDetected() : (blockAdBlock.onDetected(adBlockDetected),
                    blockAdBlock.onNotDetected(adBlockNotDetected)),
                $(".cp-popup .close").on("click", function() {
                    Cookies.set("BiS-Amazon", "value", {
                        expires: 1
                    }),
                        $(".cp-popup").addClass("hide")
                }),
                setTimeout(function() {
                    Cookies.get("BiS-Amazon") || $(".cp-popup").removeClass("hide")
                }, 2e3),
                $(".bitly").on("click", function(e) {
                    e.preventDefault();
                    var t = $("input#share-url").val()
                        , a = $("#gear-title").val();
                    -1 != t.indexOf("?") ? connector = "&" : connector = "?",
                    a.length > 0 && (t += connector + "title=" + a);
                    $.ajax({
                        url: "https://www.osrsbestinslot.com/api/bitly.php",
                        data: {
                            link: t
                        },
                        success: function(e) {
                            console.log("bitly link - " + e),
                                $("#bitly-url").html('Unique link to share this page: <a href="' + e + '">' + e + "</a>")
                        },
                        error: function() {
                            $("#bitly-url").text("Bitly Query failed :( - Try again later."),
                                console.log("[OSRS - BiS] bitly query FAILED")
                        }
                    })
                }),
                $("#gear-title").keyup(function(e) {
                    e.preventDefault(),
                        $(".cp-gear-title h4").text($(this).val()),
                        "" !== $(this).val() ? $(".cp-equipment").addClass("cp-equipment--with-title") : $(".cp-equipment").removeClass("cp-equipment--with-title"),
                    13 == e.keyCode && (e.preventDefault(),
                        console.log("asdsad"))
                });
            var tileFilter = function(e) {
                var t, a, s, n = e.dataAttr, i = e.elem, r = e.filterInput, o = e.hiddenClass, l = e.activeClass, c = e.matchingResults, d = e.clearFilter;
                function m() {
                    t = $(i + "." + l).length,
                        totalElements = $(i).length,
                        $(c).html("<p>Showing <strong>" + t + "</strong> of <strong>" + totalElements + "</strong> bosses."),
                        $(c).parent().addClass("is-active")
                }
                function p() {
                    a = [],
                        $(i).removeClass(o),
                        $(i).addClass(l),
                        $(r).each(function() {
                            $(this).attr("checked", !1),
                                $(this).prop("disabled", !1),
                                $(this).parent().removeClass(o)
                        })
                }
                return $(d).on("click", function() {
                    p(),
                        setTimeout(function() {
                            m()
                        }, 200)
                }),
                $("body").hasClass("page-boss-gear-and-guides") && (s = "",
                    a = [],
                    $(r).on("click", function() {
                        var e, t, c;
                        s = $(this).data(n),
                            a.includes(s) ? a.splice($.inArray(s, a), 1) : a.push(s),
                            "" == a ? ($(i).removeClass(o),
                                $(i).addClass(l),
                                $(".cp-boss-gear__cat").removeClass("hide").addClass("show")) : (t = a,
                                c = "",
                                $(i).each(function() {
                                    c = $(this).data(n),
                                        e = c.split(",");
                                    for (var a = 0; a < t.length; a++) {
                                        if (!(e.indexOf(t[a]) >= 0)) {
                                            $(this).addClass(o),
                                                $(this).removeClass(l);
                                            break
                                        }
                                        $(this).removeClass(o),
                                            $(this).addClass(l)
                                    }
                                }),
                                $(".cp-boss-gear__cat").each(function() {
                                    $(this).find(".cp-boss-gear__boss-info.show").length ? $(this).removeClass("hide").addClass("show") : $(this).removeClass("show").addClass("hide")
                                })),
                            setTimeout(function() {
                                var e, t;
                                m(),
                                    t = [],
                                    $(i).each(function() {
                                        $(this).hasClass(l) && (t += $(this).data(n))
                                    }),
                                    t = t.split(","),
                                    $(r).each(function() {
                                        e = $(this).data(n);
                                        for (var a = 0; a < t.length; a++) {
                                            if (e == t[a]) {
                                                $(this).parent().removeClass(o),
                                                    $(this).prop("disabled", !1);
                                                break
                                            }
                                            $(this).parent().addClass(o),
                                                $(this).prop("disabled", !0)
                                        }
                                    })
                            }, 200)
                    }),
                    m()),
                    {
                        clearFilter: p
                    }
            };
            function loadBossGear() {
                function e(e) {
                    return ID = $(".active .slot." + e).children("ul").children("li.active").data("id"),
                        ID
                }
                stat = "",
                    stats = "",
                    hand = "1",
                    stats = {
                        type: "none"
                    },
                    type = "",
                void 0 !== e("glovesslot") && grabItem(glovesslot, stats, stat, e("glovesslot")),
                void 0 !== e("capeslot") && grabItem(capeslot, stats, stat, e("capeslot")),
                void 0 !== e("neckslot") && grabItem(neckslot, stats, stat, e("neckslot")),
                void 0 !== e("ringslot") && grabItem(ringslot, stats, stat, e("ringslot")),
                void 0 !== e("bootsslot") && grabItem(bootsslot, stats, stat, e("bootsslot")),
                void 0 !== e("headslot") && grabItem(headslot, stats, stat, e("headslot")),
                void 0 !== e("chestslot") && grabItem(chestslot, stats, stat, e("chestslot")),
                void 0 !== e("legsslot") && grabItem(legsslot, stats, stat, e("legsslot")),
                void 0 !== e("ammoslot") && grabItem(ammoslot, stats, stat, e("ammoslot")),
                void 0 !== e("shieldslot") && grabItem(shieldslot, stats, stat, e("shieldslot")),
                void 0 !== e("weaponslot") && grabItem(weaponslot, stats, stat, e("weaponslot"))
            }
            function resetBossGear() {
                $(".cp-boss-setups__setup.active .equipment .slot").children("img").remove(),
                    $(".cp-boss-setups__setup.active .equipment .slot").removeClass("active"),
                    $(".cp-boss-setups__setup.active .equipment .slot span").data("id", ""),
                    $(".cp-boss-setups__setup.active .equipment .slot span").data("name", ""),
                    $(".cp-boss-setups__setup.active .combat-stats .value").html("0")
            }
            function loadBossSetups() {
                $(".cp-boss-nav a").on("click", function(e) {
                    e.preventDefault(),
                        target = $(this).data("target"),
                        $(".cp-boss-nav a").removeClass("active"),
                        $(".cp-boss-setups__setup").removeClass("active"),
                        $(".cp-boss-setups__setup." + target).addClass("active"),
                        $(this).addClass("active"),
                        resetBossGear(),
                        loadBossGear()
                })
            }
            function combatStats(e, t) {
                $(".active .attack-bonus .stab .value").html(parseInt($(".active .attack-bonus .stab .value").html()) + parseInt(e[t].equipment.attack_stab)),
                    $(".active .attack-bonus .slash .value").html(parseInt($(".active .attack-bonus .slash .value").html()) + parseInt(e[t].equipment.attack_slash)),
                    $(".active .attack-bonus .crush .value").html(parseInt($(".active .attack-bonus .crush .value").html()) + parseInt(e[t].equipment.attack_crush)),
                    $(".active .attack-bonus .magic .value").html(parseInt($(".active .attack-bonus .magic .value").html()) + parseInt(e[t].equipment.attack_magic)),
                    $(".active .attack-bonus .ranged .value").html(parseInt($(".active .attack-bonus .ranged .value").html()) + parseInt(e[t].equipment.attack_ranged)),
                    $(".active .defence-bonus .stab .value").html(parseInt($(".active .defence-bonus .stab .value").html()) + parseInt(e[t].equipment.defence_stab)),
                    $(".active .defence-bonus .slash .value").html(parseInt($(".active .defence-bonus .slash .value").html()) + parseInt(e[t].equipment.defence_slash)),
                    $(".active .defence-bonus .crush .value").html(parseInt($(".active .defence-bonus .crush .value").html()) + parseInt(e[t].equipment.defence_crush)),
                    $(".active .defence-bonus .magic .value").html(parseInt($(".active .defence-bonus .magic .value").html()) + parseInt(e[t].equipment.defence_magic)),
                    $(".active .defence-bonus .ranged .value").html(parseInt($(".active .defence-bonus .ranged .value").html()) + parseInt(e[t].equipment.defence_ranged)),
                    $(".active .other-bonus .melee-strength .value").html(parseInt($(".active .other-bonus .melee-strength .value").html()) + parseInt(e[t].equipment.melee_strength)),
                    $(".active .other-bonus .ranged-strength .value").html(parseInt($(".active .other-bonus .ranged-strength .value").html()) + parseInt(e[t].equipment.ranged_strength)),
                    $(".active .other-bonus .magic-damage .value").html(parseInt($(".active .other-bonus .magic-damage .value").html()) + parseInt(e[t].equipment.magic_damage)),
                    $(".active .other-bonus .prayer .value").html(parseInt($(".active .other-bonus .prayer .value").html()) + parseInt(e[t].equipment.prayer))
            }
            function grabSingleItem(value, value2, targetSlot, targetSlot2, gearSlot, gearSlot2, offHand, name) {
                if (slotNumber = targetSlot.slice(-1),
                    1 == offHand && "shieldslot" == gearSlot ? (target = $("." + targetSlot2),
                        target2 = "",
                        gearSlot2 = "weaponslot",
                        $(".combat-stats .value-" + slotNumber).html("0"),
                        offHandItems = [parseInt(value), parseInt(value2)]) : 1 == offHand && "weaponslot" == gearSlot ? (target = $("." + targetSlot),
                        target2 = "",
                        gearSlot2 = "shieldslot",
                        offHandItems = [parseInt(value), parseInt(value2)],
                        $(".combat-stats .value-" + slotNumber).html("0")) : (target = $("." + targetSlot),
                        target2 = $(".slot-" + (parseInt(targetSlot.slice(-1)) + 2)),
                        offHandItems = "",
                        gearSlot2 = ""),
                    target.find("img").remove(),
                target2 && target2.find("img").remove(),
                    img = "<img src='https://chisel.weirdgloop.org/static/img/osrs-sprite/" + value + ".png'>",
                    target.children("span").data("id", value),
                    $(target).find(".slot-name").html(name),
                    $(target).append(img),
                    gearSlot = eval(gearSlot),
                    gearSlot2 = eval(gearSlot2),
                1 == offHand) {
                    for (var i in gearSlot)
                        jQuery.inArray(gearSlot[i].id, offHandItems) > -1 && ($(".attack-bonus .stab .value-" + slotNumber).html(parseInt($(".attack-bonus .stab .value-" + slotNumber).html()) + parseInt(gearSlot[i].equipment.attack_stab)),
                            $(".attack-bonus .slash .value-" + slotNumber).html(parseInt($(".attack-bonus .slash .value-" + slotNumber).html()) + parseInt(gearSlot[i].equipment.attack_slash)),
                            $(".attack-bonus .crush .value-" + slotNumber).html(parseInt($(".attack-bonus .crush .value-" + slotNumber).html()) + parseInt(gearSlot[i].equipment.attack_crush)),
                            $(".attack-bonus .magic .value-" + slotNumber).html(parseInt($(".attack-bonus .magic .value-" + slotNumber).html()) + parseInt(gearSlot[i].equipment.attack_magic)),
                            $(".attack-bonus .ranged .value-" + slotNumber).html(parseInt($(".attack-bonus .ranged .value-" + slotNumber).html()) + parseInt(gearSlot[i].equipment.attack_ranged)),
                            $(".defence-bonus .stab .value-" + slotNumber).html(parseInt($(".defence-bonus .stab .value-" + slotNumber).html()) + parseInt(gearSlot[i].equipment.defence_ranged)),
                            $(".defence-bonus .slash .value-" + slotNumber).html(parseInt($(".defence-bonus .slash .value-" + slotNumber).html()) + parseInt(gearSlot[i].equipment.defence_slash)),
                            $(".defence-bonus .crush .value-" + slotNumber).html(parseInt($(".defence-bonus .crush .value-" + slotNumber).html()) + parseInt(gearSlot[i].equipment.defence_crush)),
                            $(".defence-bonus .magic .value-" + slotNumber).html(parseInt($(".defence-bonus .magic .value-" + slotNumber).html()) + parseInt(gearSlot[i].equipment.defence_magic)),
                            $(".defence-bonus .ranged .value-" + slotNumber).html(parseInt($(".defence-bonus .ranged .value-" + slotNumber).html()) + parseInt(gearSlot[i].equipment.defence_ranged)),
                            $(".other-bonus .melee-strength .value-" + slotNumber).html(parseInt($(".other-bonus .melee-strength .value-" + slotNumber).html()) + parseInt(gearSlot[i].equipment.melee_strength)),
                            $(".other-bonus .ranged-strength .value-" + slotNumber).html(parseInt($(".other-bonus .ranged-strength .value-" + slotNumber).html()) + parseInt(gearSlot[i].equipment.ranged_strength)),
                            $(".other-bonus .magic-damage .value-" + slotNumber).html(parseInt($(".other-bonus .magic-damage .value-" + slotNumber).html()) + parseInt(gearSlot[i].equipment.magic_damage)),
                            $(".other-bonus .prayer .value-" + slotNumber).html(parseInt($(".other-bonus .prayer .value-" + slotNumber).html()) + parseInt(gearSlot[i].equipment.prayer)));
                    for (var i in gearSlot2)
                        jQuery.inArray(gearSlot2[i].id, offHandItems) > -1 && ($(".attack-bonus .stab .value-" + slotNumber).html(parseInt($(".attack-bonus .stab .value-" + slotNumber).html()) + parseInt(gearSlot2[i].equipment.attack_stab)),
                            $(".attack-bonus .slash .value-" + slotNumber).html(parseInt($(".attack-bonus .slash .value-" + slotNumber).html()) + parseInt(gearSlot2[i].equipment.attack_slash)),
                            $(".attack-bonus .crush .value-" + slotNumber).html(parseInt($(".attack-bonus .crush .value-" + slotNumber).html()) + parseInt(gearSlot2[i].equipment.attack_crush)),
                            $(".attack-bonus .magic .value-" + slotNumber).html(parseInt($(".attack-bonus .magic .value-" + slotNumber).html()) + parseInt(gearSlot2[i].equipment.attack_magic)),
                            $(".attack-bonus .ranged .value-" + slotNumber).html(parseInt($(".attack-bonus .ranged .value-" + slotNumber).html()) + parseInt(gearSlot2[i].equipment.attack_ranged)),
                            $(".defence-bonus .stab .value-" + slotNumber).html(parseInt($(".defence-bonus .stab .value-" + slotNumber).html()) + parseInt(gearSlot2[i].equipment.defence_ranged)),
                            $(".defence-bonus .slash .value-" + slotNumber).html(parseInt($(".defence-bonus .slash .value-" + slotNumber).html()) + parseInt(gearSlot2[i].equipment.defence_slash)),
                            $(".defence-bonus .crush .value-" + slotNumber).html(parseInt($(".defence-bonus .crush .value-" + slotNumber).html()) + parseInt(gearSlot2[i].equipment.defence_crush)),
                            $(".defence-bonus .magic .value-" + slotNumber).html(parseInt($(".defence-bonus .magic .value-" + slotNumber).html()) + parseInt(gearSlot2[i].equipment.defence_magic)),
                            $(".defence-bonus .ranged .value-" + slotNumber).html(parseInt($(".defence-bonus .ranged .value-" + slotNumber).html()) + parseInt(gearSlot2[i].equipment.defence_ranged)),
                            $(".other-bonus .melee-strength .value-" + slotNumber).html(parseInt($(".other-bonus .melee-strength .value-" + slotNumber).html()) + parseInt(gearSlot2[i].equipment.melee_strength)),
                            $(".other-bonus .ranged-strength .value-" + slotNumber).html(parseInt($(".other-bonus .ranged-strength .value-" + slotNumber).html()) + parseInt(gearSlot2[i].equipment.ranged_strength)),
                            $(".other-bonus .magic-damage .value-" + slotNumber).html(parseInt($(".other-bonus .magic-damage .value-" + slotNumber).html()) + parseInt(gearSlot2[i].equipment.magic_damage)),
                            $(".other-bonus .prayer .value-" + slotNumber).html(parseInt($(".other-bonus .prayer .value-" + slotNumber).html()) + parseInt(gearSlot2[i].equipment.prayer)))
                } else
                    for (var i in gearSlot)
                        gearSlot[i].id == value && ($(".attack-bonus .stab .value-" + slotNumber).html(parseInt(gearSlot[i].equipment.attack_stab)),
                            $(".attack-bonus .slash .value-" + slotNumber).html(parseInt(gearSlot[i].equipment.attack_slash)),
                            $(".attack-bonus .crush .value-" + slotNumber).html(parseInt(gearSlot[i].equipment.attack_crush)),
                            $(".attack-bonus .magic .value-" + slotNumber).html(parseInt(gearSlot[i].equipment.attack_magic)),
                            $(".attack-bonus .ranged .value-" + slotNumber).html(parseInt(gearSlot[i].equipment.attack_ranged)),
                            $(".defence-bonus .stab .value-" + slotNumber).html(parseInt(gearSlot[i].equipment.defence_ranged)),
                            $(".defence-bonus .slash .value-" + slotNumber).html(parseInt(gearSlot[i].equipment.defence_slash)),
                            $(".defence-bonus .crush .value-" + slotNumber).html(parseInt(gearSlot[i].equipment.defence_crush)),
                            $(".defence-bonus .magic .value-" + slotNumber).html(parseInt(gearSlot[i].equipment.defence_magic)),
                            $(".defence-bonus .ranged .value-" + slotNumber).html(parseInt(gearSlot[i].equipment.defence_ranged)),
                            $(".other-bonus .melee-strength .value-" + slotNumber).html(parseInt(gearSlot[i].equipment.melee_strength)),
                            $(".other-bonus .ranged-strength .value-" + slotNumber).html(parseInt(gearSlot[i].equipment.ranged_strength)),
                            $(".other-bonus .magic-damage .value-" + slotNumber).html(parseInt(gearSlot[i].equipment.magic_damage)),
                            $(".other-bonus .prayer .value-" + slotNumber).html(parseInt(gearSlot[i].equipment.prayer)));
                compareItems()
            }
            function compareItems() {
                $(".stat .value-1").removeClass("higher"),
                    $(".stat .value-2").removeClass("higher"),
                    $(".stat").each(function() {
                        value1 = parseInt($(this).children(".value-1").html()),
                            value2 = parseInt($(this).children(".value-2").html()),
                        value1 !== value2 && (value1 > value2 && $(this).children(".value-1").addClass("higher"),
                        value2 > value1 && $(this).children(".value-2").addClass("higher"))
                    })
            }
            function loadCompareGear(e, t, a, s, n) {
                for (var i in gearSlot = "",
                    gearSlot2 = "",
                    headslot)
                    headslot[i].id == e && (gearSlot = "headslot",
                        name = headslot[i].name);
                for (var i in capeslot)
                    capeslot[i].id == e && (gearSlot = "capeslot",
                        name = capeslot[i].name);
                for (var i in neckslot)
                    neckslot[i].id == e && (gearSlot = "neckslot",
                        name = neckslot[i].name);
                for (var i in ammoslot)
                    ammoslot[i].id == e && (gearSlot = "ammoslot",
                        name = ammoslot[i].name);
                for (var i in weaponslot)
                    weaponslot[i].id == e && (gearSlot = "weaponslot",
                        name = weaponslot[i].name);
                for (var i in chestslot)
                    chestslot[i].id == e && (gearSlot = "chestslot",
                        name = chestslot[i].name);
                for (var i in shieldslot)
                    shieldslot[i].id == e && (gearSlot = "shieldslot",
                        name = shieldslot[i].name);
                for (var i in legsslot)
                    legsslot[i].id == e && (gearSlot = "legsslot",
                        name = legsslot[i].name);
                for (var i in glovesslot)
                    glovesslot[i].id == e && (gearSlot = "glovesslot",
                        name = glovesslot[i].name);
                for (var i in bootsslot)
                    bootsslot[i].id == e && (gearSlot = "bootsslot",
                        name = bootsslot[i].name);
                for (var i in ringslot)
                    ringslot[i].id == e && (gearSlot = "ringslot",
                        name = ringslot[i].name);
                1 == n && gearSlot == shieldslot && (gearSlot2 = "weaponslot"),
                1 == n && gearSlot == weaponslot && (gearSlot2 = "shieldslot"),
                    grabSingleItem(e, t, a, s, gearSlot, gearSlot2, n, name)
            }
            window.stuff = tileFilter({
                dataAttr: "filter",
                elem: ".cp-boss-gear__boss-info",
                filterInput: ".cp-boss-filters__item input",
                hiddenClass: "hide",
                activeClass: "show",
                matchingResults: ".cp-boss-filters__results",
                clearFilter: ".cp-filter__clear"
            }),
                $(".cp-boss-filters__item-upper").on("click", function() {
                    $(this).toggleClass("active")
                }),
            ($("body").hasClass("boss-gear-template-default") || $("body").hasClass("slayer-gear-template-default")) && (loadBossGear(),
                loadBossSetups()),
                $(".single-boss-gear .slot-prev").on("click", function() {
                    var e = $(this).siblings("ul").children("li").length - 1;
                    console.log(e),
                        $(this).siblings("ul").children("li.active").removeClass("active").addClass("inactive").next("li").addClass("active").removeClass("inactive"),
                        resetBossGear(),
                        loadBossGear(),
                        console.log("skipped to item " + $(this).siblings("ul").children("li.active").index()),
                    $(this).siblings("ul").children("li.active").index() == e && ($(this).addClass("hide"),
                        $(this).siblings(".slot-next").removeClass("hide")),
                    $(this).siblings("ul").children("li.active").index() > 0 && $(this).siblings("ul").children("li.active").index() < e && ($(this).siblings(".slot-prev").removeClass("hide"),
                        $(this).siblings(".slot-next").removeClass("hide"))
                }),
                $(".single-boss-gear .slot-next").on("click", function() {
                    var e = $(this).siblings("ul").children("li").length - 1;
                    $(this).siblings("ul").children("li.active").removeClass("active").addClass("inactive").prev("li").addClass("active").removeClass("inactive"),
                        resetBossGear(),
                        loadBossGear(),
                    0 == $(this).siblings("ul").children("li.active").index() && ($(this).addClass("hide"),
                        $(this).siblings(".slot-prev").removeClass("hide")),
                    $(this).siblings("ul").children("li.active").index() > 0 && $(this).siblings("ul").children("li.active").index() < e && ($(this).siblings(".slot-prev").removeClass("hide"),
                        $(this).siblings(".slot-next").removeClass("hide"))
                }),
                $(".cp-boss-gear__boss-tabs--links a").on("click", function() {
                    target = $(this).attr("href"),
                        console.log(target),
                        $(".cp-boss-gear__boss-tabs--content").each(function() {
                            $(this).data("boss") == target ? $(this).show() : $(this).hide()
                        })
                }),
                function() {
                    "use strict";
                    function e(e, t) {
                        return 1 - Math.pow(1 - e, t)
                    }
                    function t(e, t) {
                        return Math.ceil(Math.log(1 - t) / Math.log(1 - e))
                    }
                    var a = document.querySelector(".cp-drop-calc");
                    if (a) {
                        var s = a.getAttribute("data-drops-url")
                            , n = {};
                        "loading" === document.readyState ? document.addEventListener("DOMContentLoaded", u) : u()
                    }
                    function i(e) {
                        return document.getElementById(e)
                    }
                    function r(e) {
                        var t = parseInt(String(e).replace(/[^\d]/g, ""), 10);
                        return isFinite(t) ? t : 0
                    }
                    function o(e) {
                        return Number(e).toLocaleString("en-US")
                    }
                    function l(e) {
                        return e >= .9995 ? "99.9%" : (100 * e).toFixed(1) + "%"
                    }
                    function c(e, t) {
                        for (var s = a.querySelectorAll(".cp-drop-boss"), r = 0; r < s.length; r++)
                            s[r].classList.remove("sel");
                        t && t.classList.add("sel");
                        var l = n[e] && n[e].drops || []
                            , c = i("drop-item");
                        c.innerHTML = "",
                            l.forEach(function(e, t) {
                                var a = document.createElement("option");
                                a.value = t,
                                    a.textContent = e.item + "  (1/" + o(e.den) + ")",
                                    c.appendChild(a)
                            }),
                            c.disabled = 0 === l.length,
                        l.length && (c.value = "0",
                            d(e, 0))
                    }
                    function d(e, t) {
                        var a = ((n[e] || {}).drops || [])[t];
                        if (a) {
                            0;
                            var s = i("drop-selected")
                                , r = i("drop-spr-img");
                            a.sprite ? (r.src = a.sprite,
                                r.style.visibility = "visible") : (r.removeAttribute("src"),
                                r.style.visibility = "hidden"),
                                i("drop-item-name").textContent = a.item,
                                i("drop-item-rate").textContent = "Drop rate 1 / " + o(a.den),
                            s && (s.hidden = !1),
                                i("drop-chance").value = "1/" + a.den,
                                p()
                        }
                    }
                    function m(e) {
                        var t = i("drop-gauge-arc")
                            , a = i("drop-gauge-needle");
                        t && t.setAttribute("stroke-dashoffset", (364.4 * (1 - e)).toFixed(1)),
                        a && a.setAttribute("transform", "translate(140,150) rotate(" + (180 * e - 180).toFixed(2) + ")"),
                            i("drop-pct").textContent = e > 0 ? l(e) : "0%"
                    }
                    function p() {
                        var a = function(e) {
                            if (null == e)
                                return null;
                            var t = String(e).trim().toLowerCase().replace(/,/g, "").replace(/\s+/g, "");
                            if (!t)
                                return null;
                            if (-1 !== t.indexOf("/")) {
                                var a = t.split("/")
                                    , s = parseFloat(a[0])
                                    , n = parseFloat(a[1]);
                                return isFinite(s) && isFinite(n) && 0 !== n ? s / n : null
                            }
                            var i = parseFloat(t);
                            return isFinite(i) ? i > 1 ? 1 / i : i : null
                        }(i("drop-chance").value);
                        if (null == a || a <= 0 || a > 1)
                            return m(0),
                                i("drop-verdict").textContent = "Enter a valid rate",
                                i("drop-verdict").className = "cp-drop-verdict",
                                i("drop-sub").textContent = "Type a rate like 1/128 or pick a drop above.",
                                i("drop-m50").textContent = i("drop-m90").textContent = i("drop-m99").textContent = "—",
                                void (i("drop-spark") && (i("drop-spark").innerHTML = ""));
                        var s = r(i("drop-kills").value)
                            , n = e(a, s);
                        m(n);
                        var c, d, p, u = i("drop-verdict"), g = i("drop-sub");
                        s <= 0 ? (c = "Ready when you are",
                            d = "",
                            p = "Enter your kill count to see your odds.") : n < .5 ? (c = "You're early",
                            d = "lucky",
                            p = "Most players are not done by " + o(s) + " KC yet — no bad luck.") : n < .85 ? (c = "Right on pace",
                            d = "",
                            p = "About " + l(n) + " of players would have it by " + o(s) + " KC.") : n < .95 ? (c = "You're going dry",
                            d = "dry",
                            p = "Drier than <b>" + l(n) + "</b> of players at " + o(s) + " KC.") : (c = "Brutally dry",
                            d = "dry",
                            p = "Drier than <b>" + l(n) + "</b> of players at " + o(s) + " KC. Ouch."),
                            u.textContent = c,
                            u.className = "cp-drop-verdict" + (d ? " " + d : ""),
                            g.innerHTML = p + " &middot; expected 1 / " + o(Math.round(function(e) {
                                return 1 / e
                            }(a))),
                            i("drop-m50").textContent = o(t(a, .5)),
                            i("drop-m90").textContent = o(t(a, .9)),
                            i("drop-m99").textContent = o(t(a, .99)),
                            function(a, s) {
                                var n = i("drop-spark");
                                if (n) {
                                    for (var r = 420, o = 104, l = Math.max(t(a, .99), s, 1), c = [], d = 0; d <= 80; d++) {
                                        var m = e(a, d / 80 * l);
                                        c.push([d / 80 * r, 96 - 88 * m])
                                    }
                                    var p = c.map(function(e, t) {
                                        return (t ? "L" : "M") + e[0].toFixed(1) + " " + e[1].toFixed(1)
                                    }).join(" ")
                                        , u = Math.min(s / l, 1) * r
                                        , g = 96 - 88 * e(a, s);
                                    n.innerHTML = '<svg viewBox="0 0 420 104" width="100%" height="104" preserveAspectRatio="none"><defs><linearGradient id="cpDropFill" x1="0" y1="0" x2="0" y2="1"><stop offset="0" stop-color="#d26b28" stop-opacity="0.45"/><stop offset="1" stop-color="#d26b28" stop-opacity="0.04"/></linearGradient></defs><path d="' + p + " L" + r + " " + o + " L0 " + o + ' Z" fill="url(#cpDropFill)"/><path d="' + p + '" fill="none" stroke="#d26b28" stroke-width="2"/><line x1="' + u.toFixed(1) + '" y1="2" x2="' + u.toFixed(1) + '" y2="96" stroke="#412619" stroke-opacity="0.3" stroke-dasharray="3 3"/><circle cx="' + u.toFixed(1) + '" cy="' + g.toFixed(1) + '" r="4.5" fill="#f3e6cf" stroke="#d26b28" stroke-width="2"/></svg>'
                                }
                            }(a, s)
                    }
                    function u() {
                        i("drop-item").addEventListener("change", function() {
                            var e = a.querySelector(".cp-drop-boss.sel");
                            e && e.dataset.boss && d(e.dataset.boss, r(this.value))
                        }),
                            ["drop-chance", "drop-kills", "drop-obtained"].forEach(function(e) {
                                var t = i(e);
                                t && t.addEventListener("input", p)
                            }),
                        s && fetch(s, {
                            credentials: "omit"
                        }).then(function(e) {
                            return e.json()
                        }).then(function(e) {
                            var t;
                            n = e || {},
                            (t = i("drop-bosses")) && (t.innerHTML = "",
                                Object.keys(n).sort().forEach(function(e) {
                                    var a = n[e]
                                        , s = document.createElement("div");
                                    s.className = "cp-drop-boss",
                                        s.setAttribute("role", "button"),
                                        s.setAttribute("tabindex", "0"),
                                        s.dataset.boss = e;
                                    var i = a.icon ? '<img src="' + a.icon + '" alt="" loading="lazy">' : '<span class="cp-drop-boss-ph"></span>';
                                    s.innerHTML = i + "<span>" + e + "</span>",
                                        s.addEventListener("click", function() {
                                            c(e, s)
                                        }),
                                        s.addEventListener("keypress", function(t) {
                                            "Enter" === t.key && c(e, s)
                                        }),
                                        t.appendChild(s)
                                }));
                            var a = i("drop-bosses").querySelector(".cp-drop-boss");
                            a && c(a.dataset.boss, a)
                        }).catch(function() {
                            var e = i("drop-bosses");
                            e && (e.innerHTML = '<div class="cp-drop-loading">Could not load boss data. Enter a custom rate below.</div>')
                        })
                    }
                }(),
                function() {
                    "use strict";
                    var e = document.getElementById("ge-tracker");
                    if (e) {
                        var t = "https://prices.runescape.wiki/api/v1/osrs"
                            , a = e.getAttribute("data-items-url") || ""
                            , s = (e.getAttribute("data-popular") || "").split(",").map(function(e) {
                            return parseInt(e, 10)
                        }).filter(Boolean)
                            , n = 5e6
                            , i = {
                            input: d("ge-tracker-search"),
                            suggest: e.querySelector(".cp-ge-suggest"),
                            popular: d("ge-popular"),
                            spr: d("ge-spr-img"),
                            name: d("ge-name"),
                            updated: d("ge-updated"),
                            buy: d("ge-buy"),
                            sell: d("ge-sell"),
                            marginGp: d("ge-margin-gp"),
                            marginPct: d("ge-margin-pct"),
                            limit: d("ge-limit"),
                            tax: d("ge-tax"),
                            potential: d("ge-potential"),
                            chart: d("ge-chart"),
                            chartMeta: d("ge-chart-meta"),
                            wiki: d("ge-wiki")
                        }
                            , r = []
                            , o = {}
                            , l = -1
                            , c = [];
                        "loading" === document.readyState ? document.addEventListener("DOMContentLoaded", S) : S()
                    }
                    function d(e) {
                        return document.getElementById(e)
                    }
                    function m(e) {
                        return null == e || isNaN(e) ? "—" : Math.round(e).toLocaleString("en-US") + " gp"
                    }
                    function p(e) {
                        return null == e || isNaN(e) ? "—" : (e >= 0 ? "+" : "") + e.toFixed(1) + "%"
                    }
                    function u(e) {
                        return e ? "https://oldschool.runescape.wiki/images/" + encodeURIComponent(e.replace(/ /g, "_")) : ""
                    }
                    function g(e) {
                        return String(e).replace(/[&<>"']/g, function(e) {
                            return {
                                "&": "&amp;",
                                "<": "&lt;",
                                ">": "&gt;",
                                '"': "&quot;",
                                "'": "&#39;"
                            }[e]
                        })
                    }
                    function h(e) {
                        return fetch(e, {
                            credentials: "omit"
                        }).then(function(e) {
                            if (!e.ok)
                                throw new Error("HTTP " + e.status);
                            return e.json()
                        })
                    }
                    function b() {
                        c = [],
                            l = -1,
                        i.suggest && (i.suggest.innerHTML = "",
                            i.suggest.style.display = "none")
                    }
                    function f() {
                        !function(e) {
                            if (c = e,
                                l = -1,
                                i.suggest)
                                if (e.length) {
                                    for (var t = "", a = 0; a < e.length; a++) {
                                        var s = e[a];
                                        t += '<li class="cp-ge-suggest-item" role="option" data-id="' + s.id + '" data-index="' + a + '"><img class="cp-ge-suggest-icon" loading="lazy" alt="" src="' + u(s.icon) + '"><span class="cp-ge-suggest-name">' + g(s.name) + "</span></li>"
                                    }
                                    i.suggest.innerHTML = t,
                                        i.suggest.style.display = "block"
                                } else
                                    b()
                        }(function(e) {
                            if ((e = e.trim().toLowerCase()).length < 2)
                                return [];
                            for (var t = [], a = [], s = 0; s < r.length && t.length < 10; s++)
                                0 === r[s].name.toLowerCase().indexOf(e) && t.push(r[s]);
                            if (t.length < 10)
                                for (var n = 0; n < r.length && t.length + a.length < 10; n++)
                                    r[n].name.toLowerCase().indexOf(e) > 0 && a.push(r[n]);
                            return t.concat(a).slice(0, 10)
                        }(i.input.value))
                    }
                    function v(e) {
                        if (c.length) {
                            (l += e) < 0 && (l = c.length - 1),
                            l >= c.length && (l = 0);
                            for (var t = i.suggest.querySelectorAll(".cp-ge-suggest-item"), a = 0; a < t.length; a++)
                                t[a].classList.toggle("is-active", a === l)
                        }
                    }
                    function k(e) {
                        if ("block" === i.suggest.style.display)
                            if ("ArrowDown" === e.key)
                                e.preventDefault(),
                                    v(1);
                            else if ("ArrowUp" === e.key)
                                e.preventDefault(),
                                    v(-1);
                            else if ("Enter" === e.key) {
                                e.preventDefault();
                                var t = l >= 0 ? c[l] : c[0];
                                t && I(t.id)
                            } else
                                "Escape" === e.key && b()
                    }
                    function I(e, a) {
                        var s = o[e];
                        if (s) {
                            if (i.input.value = "",
                                b(),
                                function(e) {
                                    for (var t = i.popular ? i.popular.querySelectorAll(".cp-ge-tile") : [], a = 0; a < t.length; a++)
                                        t[a].classList.toggle("sel", parseInt(t[a].dataset.id, 10) === e)
                                }(e),
                            !a && window.history && window.history.replaceState) {
                                var r = new URL(window.location.href);
                                r.searchParams.set("item", e),
                                    window.history.replaceState({}, "", r.toString())
                            }
                            !function(e) {
                                i.name.textContent = e.name,
                                    i.spr.src = u(e.icon),
                                    i.spr.alt = e.name,
                                    i.updated.textContent = "Loading live prices…",
                                i.wiki && (i.wiki.href = "https://oldschool.runescape.wiki/w/" + encodeURIComponent(e.name.replace(/ /g, "_")));
                                var a = h(t + "/latest?id=" + e.id)
                                    , s = h(t + "/timeseries?id=" + e.id + "&timestep=24h").catch(function() {
                                    return {
                                        data: []
                                    }
                                });
                                Promise.all([a, s]).then(function(t) {
                                    var a = t[0] && t[0].data ? t[0].data[e.id] : null
                                        , s = t[1] && t[1].data ? t[1].data : [];
                                    !function(e, t, a) {
                                        var s = t && null != t.high ? t.high : null
                                            , r = t && null != t.low ? t.low : null
                                            , o = Math.max(t && t.highTime || 0, t && t.lowTime || 0);
                                        if (i.buy.textContent = m(r),
                                            i.sell.textContent = m(s),
                                            i.updated.textContent = o ? "Last trade " + function(e) {
                                                if (!e)
                                                    return "unknown";
                                                var t = Math.floor(Date.now() / 1e3) - e;
                                                return t < 0 && (t = 0),
                                                    t < 60 ? t + "s ago" : t < 3600 ? Math.floor(t / 60) + "m ago" : t < 86400 ? Math.floor(t / 3600) + "h ago" : Math.floor(t / 86400) + "d ago"
                                            }(o) : "No recent trade data",
                                        null != s && null != r) {
                                            var l = function(e) {
                                                if (!e || e <= 50)
                                                    return 0;
                                                var t = Math.floor(.02 * e);
                                                return t > n ? n : t
                                            }(s)
                                                , c = s - r - l
                                                , d = r > 0 ? c / r * 100 : null;
                                            i.marginGp.textContent = m(c),
                                                i.marginPct.textContent = p(d),
                                                $(c < 0),
                                                i.tax.textContent = m(l);
                                            var u = e.limit > 0 ? e.limit : null;
                                            i.potential.textContent = u ? m(c * u) : "—"
                                        } else
                                            i.marginGp.textContent = "—",
                                                i.marginPct.textContent = "—",
                                                $(!1),
                                                i.tax.textContent = "—",
                                                i.potential.textContent = "—";
                                        i.limit.textContent = e.limit > 0 ? e.limit.toLocaleString("en-US") : "None",
                                            function(e) {
                                                if (!i.chart)
                                                    return;
                                                for (var t = [], a = 0; a < e.length; a++) {
                                                    var s = e[a]
                                                        , n = null != s.avgHighPrice ? s.avgHighPrice : s.avgLowPrice;
                                                    null != n && null != s.timestamp && t.push([s.timestamp, n])
                                                }
                                                if (t.length < 2)
                                                    return i.chart.innerHTML = '<text x="50%" y="50%" text-anchor="middle" fill="#6b5f4d" font-size="13">No price history available</text>',
                                                        void (i.chartMeta && (i.chartMeta.textContent = ""));
                                                for (var r = 640, o = 200, l = 8, c = 8, d = t[0][0], u = t[t.length - 1][0], g = 1 / 0, h = -1 / 0, b = 0; b < t.length; b++)
                                                    t[b][1] < g && (g = t[b][1]),
                                                    t[b][1] > h && (h = t[b][1]);
                                                var f = u - d || 1
                                                    , v = h - g || 1;
                                                function k(e) {
                                                    return l + (e - d) / f * (r - 2 * l)
                                                }
                                                function I(e) {
                                                    return l + (1 - (e - g) / v) * (o - l - c)
                                                }
                                                for (var $ = [], S = 0; S < t.length; S++)
                                                    $.push(k(t[S][0]).toFixed(1) + "," + I(t[S][1]).toFixed(1));
                                                var _ = "M" + $.join(" L")
                                                    , x = _ + " L" + k(u).toFixed(1) + "," + (o - c).toFixed(1) + " L" + k(d).toFixed(1) + "," + (o - c).toFixed(1) + " Z"
                                                    , y = t[0][1]
                                                    , q = t[t.length - 1][1]
                                                    , w = q >= y
                                                    , C = w ? "#3f7a36" : "#a83a2a"
                                                    , N = w ? "rgba(63,122,54,0.16)" : "rgba(168,58,42,0.16)";
                                                if (i.chart.setAttribute("viewBox", "0 0 " + r + " " + o),
                                                    i.chart.innerHTML = '<path d="' + x + '" fill="' + N + '" stroke="none"></path><path d="' + _ + '" fill="none" stroke="' + C + '" stroke-width="2" stroke-linejoin="round" stroke-linecap="round"></path><circle cx="' + k(u).toFixed(1) + '" cy="' + I(q).toFixed(1) + '" r="4" fill="#f3e6cf" stroke="' + C + '" stroke-width="2"></circle>',
                                                    i.chartMeta) {
                                                    var M = Math.round((u - d) / 86400)
                                                        , O = y > 0 ? (q - y) / y * 100 : 0;
                                                    i.chartMeta.textContent = "Daily average, last " + M + " days — high " + m(h) + ", low " + m(g) + " (" + p(O) + ")"
                                                }
                                            }(a)
                                    }(e, a, s)
                                }).catch(function(e) {
                                    i.updated.innerHTML = '<span class="cp-ge-error">Could not load prices (' + g(e.message) + "). Try again.</span>"
                                })
                            }(s)
                        }
                    }
                    function $(e) {
                        i.marginGp.classList.toggle("is-negative", e),
                            i.marginPct.classList.toggle("is-negative", e)
                    }
                    function S() {
                        a && h(a).then(function(t) {
                            r = Array.isArray(t) ? t : [],
                                o = {};
                            for (var a = 0; a < r.length; a++)
                                o[r[a].id] = r[a];
                            i.input.addEventListener("input", f),
                                i.input.addEventListener("keydown", k),
                                i.input.addEventListener("focus", f),
                                i.suggest.addEventListener("mousedown", function(e) {
                                    var t = e.target.closest(".cp-ge-suggest-item");
                                    t && (e.preventDefault(),
                                        I(parseInt(t.getAttribute("data-id"), 10)))
                                }),
                                document.addEventListener("click", function(t) {
                                    e.contains(t.target) || b()
                                }),
                                function() {
                                    if (i.popular) {
                                        i.popular.innerHTML = "";
                                        var e = 0;
                                        s.forEach(function(t) {
                                            var a = o[t];
                                            if (a) {
                                                e++;
                                                var s = document.createElement("div");
                                                s.className = "cp-ge-tile",
                                                    s.setAttribute("role", "button"),
                                                    s.setAttribute("tabindex", "0"),
                                                    s.dataset.id = t,
                                                    s.innerHTML = '<img src="' + u(a.icon) + '" alt="" loading="lazy"><span>' + g(a.name) + "</span>",
                                                    s.addEventListener("click", function() {
                                                        I(t)
                                                    }),
                                                    s.addEventListener("keypress", function(e) {
                                                        "Enter" === e.key && I(t)
                                                    }),
                                                    i.popular.appendChild(s)
                                            }
                                        }),
                                        e || (i.popular.innerHTML = '<div class="cp-ge-loading">Search for any item above.</div>')
                                    }
                                }();
                            var n = function() {
                                var e = new URLSearchParams(window.location.search).get("item");
                                if (!e)
                                    return null;
                                var t = parseInt(e, 10);
                                if (!isNaN(t) && o[t])
                                    return t;
                                for (var a = e.toLowerCase(), s = 0; s < r.length; s++)
                                    if (r[s].name.toLowerCase() === a)
                                        return r[s].id;
                                return null
                            }();
                            n ? I(n, !0) : s.length && o[s[0]] && I(s[0], !0)
                        }).catch(function() {
                            i.popular && (i.popular.innerHTML = '<div class="cp-ge-loading">Could not load the item list. Refresh to try again.</div>')
                        })
                    }
                }(),
                $.ajax({
                    url: "https://www.osrsbestinslot.com/api/getTracker.php",
                    dataType: "json",
                    type: "GET",
                    success: function(e) {
                        var t = e.data.usersOnline
                            , a = convertToK(e.data.totalProfit) + "illion GP";
                        $(".ge-tracker-users").append(t),
                            $(".ge-tracker-total").append(a)
                    },
                    error: function(e, t) {}
                }),
                $(".page-gear-compare .dropdown-wrapper select").on("change", function(e) {
                    null !== $(this).val() && "Select" !== $(this).val() && (stat = "",
                        stats = "",
                        hand = "1",
                        stats = {
                            type: "none"
                        },
                        type = "",
                        e.preventDefault(),
                        value = $(this).val(),
                        value2 = "",
                        name = $(this).children("option:selected").text(),
                        parent = $(this).parent("fieldset"),
                        targetSlot = $(this).parents(".cp-gear-select").data("slot"),
                        targetSlot2 = "",
                        gearSlot2 = "",
                    parent.hasClass("weapon") && (hand = $(this).children("option:selected").data("hand")),
                        (parent.hasClass("weapon") || parent.hasClass("shield")) && 1 == hand ? parent.siblings(".off-hand").removeClass("hidden") : (parent.siblings(".off-hand").addClass("hidden"),
                            parent.siblings(".off-hand").children("input").prop("checked", !1),
                            targetSlotOffhand = parseInt(targetSlot.slice(-1)) + 2,
                            $(".compare-row-two .slot-" + targetSlotOffhand).addClass("hidden")),
                        offHand = parent.siblings(".off-hand").find("input").prop("checked"),
                        siblings = $(this).parent("fieldset").siblings("fieldset").children("select"),
                        gearSlot = $(this).attr("name"),
                        1 == offHand ? (siblings.not(".weaponslot").not(".shieldslot").val(null).trigger("change"),
                        "weaponslot" == gearSlot && (value2 = $(this).parent("fieldset").siblings("fieldset").find("select.shieldslot").val()),
                        "shieldslot" == gearSlot && (value2 = $(this).parent("fieldset").siblings("fieldset").find("select.weaponslot").val(),
                            targetSlot2 = "slot-" + (parseInt(targetSlot.slice(-1)) + 2))) : siblings.val(null).trigger("change"),
                        appendId(value, targetSlot),
                        grabSingleItem(value, value2, targetSlot, targetSlot2, gearSlot, gearSlot2, offHand, name),
                        setURL(value, targetSlot, targetSlot2))
                }),
                $(".page-gear-compare .offhand").on("change", function() {
                    targetSlot = $(this).parents(".cp-gear-select").data("slot"),
                        targetSlot = parseInt(targetSlot.slice(-1)) + 2,
                        1 == $(this).prop("checked") ? $(".compare-row-two .slot-" + targetSlot).removeClass("hidden") : $(".compare-row-two .slot-" + targetSlot).addClass("hidden")
                }),
            $("body").hasClass("page-best-in-slot-gear") && (loadBossGear(),
                loadBossSetups());
            var appendId = function(e, t, a) {
                $(".slot." + t).addClass("active");
                var s = $(".slot." + t + " ul");
                if (a)
                    a = 'data-2h="true"';
                else
                    a = 'data-2h="false"';
                s.empty(),
                    s.append('<li class="active" ' + a + ' data-id="' + e + '"></li>')
            }
                , appendInventoryItem = function(e, t) {
                var a = "<img src='https://chisel.weirdgloop.org/static/img/osrs-sprite/" + itemID + ".png'>";
                a += '<span data-id="' + e + '" data-name="' + e + '"></span>',
                    a += '<i class="show-info" data-ot-stem="false" data-ot="Show more info"></i>';
                var s = $(".cp-inventory__inventory ." + t);
                s.addClass("active").empty(),
                    s.append(a)
            };
            function resetGearPicker() {
                $(".cp-content.setup.active .equipment .slot").children("img").remove(),
                    $(".cp-content.setup.active .equipment .slot").removeClass("active"),
                    $(".cp-content.setup.active .equipment .slot span").data("id", ""),
                    $(".cp-content.setup.active .equipment .slot span").data("name", ""),
                    $(".cp-content.setup.active .combat-stats .value").html("0")
            }
            function timeSince(e) {
                var t = Math.floor((new Date - new Date(e)) / 1e3)
                    , a = Math.floor(t / 31536e3);
                return a > 1 ? a + " years" : (a = Math.floor(t / 2592e3)) > 1 ? a + " months" : (a = Math.floor(t / 86400)) > 1 ? a + " days" : (a = Math.floor(t / 3600)) > 1 ? a + " hours" : (a = Math.floor(t / 60)) > 1 ? a + " mins" : Math.floor(t) + " secs"
            }
            function convertToK(e) {
                return kVal = e,
                e > 1e3 && e < 999999 && (kVal = (e / 1e3).toFixed(1) + " k"),
                e > 999999 && e < 999999999 && (kVal = (e / 1e6).toFixed(1) + " m"),
                e > 999999999 && (kVal = (e / 1e9).toFixed(2) + " b"),
                    kVal
            }
            function checkStats(e, t) {
                return null == t.equipment.requirements && (t.equipment.requirements = {}),
                t.equipment.requirements.attack || (t.equipment.requirements.attack = 0),
                t.equipment.requirements.strength || (t.equipment.requirements.strength = 0),
                t.equipment.requirements.defence || (t.equipment.requirements.defence = 0),
                t.equipment.requirements.hitpoints || (t.equipment.requirements.hitpoints = 0),
                t.equipment.requirements.magic || (t.equipment.requirements.magic = 0),
                t.equipment.requirements.ranged || (t.equipment.requirements.ranged = 0),
                t.equipment.requirements.prayer || (t.equipment.requirements.prayer = 0),
                "2" == e.hand && (e.hand = "2h"),
                "1" == e.hand && (e.hand = "weapon"),
                !0 !== t.duplicate && e.att >= parseInt(t.equipment.requirements.attack) && e.str >= parseInt(t.equipment.requirements.strength) && e.def >= parseInt(t.equipment.requirements.defence) && e.hp >= parseInt(t.equipment.requirements.hitpoints) && e.magic >= parseInt(t.equipment.requirements.magic) && e.ranged >= parseInt(t.equipment.requirements.ranged) && e.prayer >= parseInt(t.equipment.requirements.prayer) && ("weapon" !== t.equipment.slot && "2h" !== t.equipment.slot || t.equipment.slot == e.hand)
            }
            function checkAvg(e, t) {
                return currentTotal = 0,
                    nextTotal = 0,
                    $.each(e.equipment, function(e, t) {
                        currentStat = parseInt(t),
                        currentStat > 0 && (currentTotal += currentStat)
                    }),
                    $.each(t.equipment, function(e, t) {
                        currentStat = parseInt(t),
                        currentStat > 0 && (nextTotal += currentStat)
                    }),
                nextTotal > currentTotal
            }
            function checkExtras(e, t, a) {
                if (name = e.name,
                    attStr = parseInt(stats.att) + parseInt(stats.str),
                -1 == $.inArray("max", t) && (-1 !== name.indexOf("max") || -1 !== name.indexOf("Max")))
                    return !1;
                if (-1 != $.inArray("variations", t) && (-1 !== name.indexOf("(p)") || -1 !== name.indexOf("(p+)") || -1 !== name.indexOf("(p++)") || -1 !== name.indexOf("(1)") || -1 !== name.indexOf("(2)") || -1 !== name.indexOf("(3)") || -1 !== name.indexOf("(4)") || -1 !== name.indexOf("(5)") || -1 !== name.indexOf("(6)") || -1 !== name.indexOf("(7)") || -1 !== name.indexOf("(8)") || -1 !== name.indexOf("(9)") || -1 !== name.indexOf("(10)") || -1 !== name.indexOf("(t)") || -1 !== name.indexOf("(t1)") || -1 !== name.indexOf("(t2)") || -1 !== name.indexOf("(t3)") || -1 !== name.indexOf("(t4)") || -1 !== name.indexOf("(t5)") || -1 !== name.indexOf("(t6)") || -1 !== name.indexOf("(h1)") || -1 !== name.indexOf("(h2)") || -1 !== name.indexOf("(h3)") || -1 !== name.indexOf("(h4)") || -1 !== name.indexOf("(h5)") || -1 !== name.indexOf("(g)") || -1 !== name.indexOf("(t)") || -1 !== name.indexOf("(r)") || -1 !== name.indexOf("(c)") || -1 !== name.indexOf("(kp)") || -1 !== name.indexOf("(l)") || -1 !== name.indexOf("(b)") || -1 !== name.indexOf("Gilded") || name.match(/(Agility)|(Herblore)|(Thieving)|(Runecraft)|(Herblore)|(Fletching)|(Construct)|(Mining)|(Smithing)|(Slayer cape)|(Fishing)|(Cooking)|(Firemaking)|(Woodcutting)|(Farming)|(Hunter)|(Crafting)|(Attack)|(Strength)|(Defence)|(Ranging cape)|(Prayer)|(Magic cape)/) || name.match(/(Music)|(Quest)|(Achievement diary)/) || -1 !== name.indexOf("Team-") || -1 !== name.indexOf("Onyx") || -1 !== name.indexOf("Dragonstone") || -1 !== name.indexOf("Diamond") || -1 !== name.indexOf("Ruby") || -1 !== name.indexOf("Emerald") || -1 !== name.indexOf("Sapphire") || -1 !== name.indexOf("Topaz") || -1 !== name.indexOf("Pearl") || -1 !== name.indexOf("Jade") || -1 !== name.indexOf("Opal") || -1 !== name.indexOf("/10") || -1 !== name.indexOf("Full") || -1 !== name.indexOf("full") && "Torva full helm" !== name || -1 !== name.indexOf("25") || -1 !== name.indexOf("50") || -1 !== name.indexOf("75") || -1 !== name.indexOf("100") || -1 !== name.indexOf("New") || -1 !== name.indexOf("(u)") || -1 !== name.indexOf("(or)") || -1 !== name.indexOf("Black slayer") || -1 !== name.indexOf("Red slayer") || -1 !== name.indexOf("Green slayer") || -1 !== name.indexOf("Purple slayer") || -1 !== name.indexOf("Turquoise slayer") || -1 !== name.indexOf("Hydra slayer") || -1 !== name.indexOf("Tztok slayer") || -1 !== name.indexOf("Vampyric slayer") || -1 !== name.indexOf("Tzkal slayer") || -1 !== name.indexOf("helmet (i)") || -1 !== name.indexOf("Tanzanite") || -1 !== name.indexOf("Magma") || -1 !== name.indexOf("perfected") || -1 !== name.indexOf("attuned") || -1 !== name.indexOf("basic") || -1 !== name.indexOf("inactive") || -1 !== name.indexOf("(damaged)") || -1 !== name.indexOf("Dawnbringer") || -1 !== name.indexOf("Trailblazer") || -1 !== name.indexOf("uncharged") || -1 !== name.indexOf("Blisterwood")))
                    return !1;
                if (-1 != $.inArray(e.id, [22641, 22638, 22644, 22636, 22610, 22613, 22616, 22619, 22622, 22625, 22628, 22631, 22647, 22650, 22653, 22656, 22634, 22636, 13317, 13318, 13319, 18221]))
                    return !1;
                if (-1 != $.inArray(e.id, [23611, 20593, 20408, 20784, 21205, 23628, 20557, 23630, 23622, 23652, 23654, 23626, 23624, 23613, 20598, 20599, 23640, 25518, 23646, 23642, 23644, 23638, 23632, 23637, 23634, 23636, 23635, 23619, 23615, 23620, 25517, 23617, 25515, 25739, 20407, 23597, 23593, 20582, 20405, 25516, 23653, 23601, 20423, 23603, 23605, 23607, 20425, 20426, 23639, 23591, 23633, 23599, 23595, 23648, 20389]))
                    return !1;
                if (-1 != $.inArray(e.id, [25734, 25731, 25736]))
                    return !1;
                if (-1 != $.inArray(e.id, [13317, 13318, 13319, 24189, 24190, 24191, 24413, 25001, 25004, 25007, 25010, 25013, 25016, 25019, 25022, 25025, 25028, 25031, 25034, 25037, 25048, 25050, 25052, 25054, 25056, 26503, 26505, 26507, 26509, 26511, 26513, 26515, 26723, 26724, 26725, 26726, 26727, 26728, 26729, 26730, 26731, 26732, 26733, 26734, 26735, 26736, 26737, 26738, 26739, 26740, 26741, 26742, 26743, 26744, 26745, 26746, 26747, 26748, 28702, 28712, 28715, 28718, 28721, 28724, 28727, 28730, 28733, 28736, 28739, 28742, 28745, 28748, 28757, 28759, 28761, 28763, 29607, 29609, 29613, 29615, 29617]))
                    return !1;
                if (-1 != $.inArray(e.id, [24617, 27836, 27847, 27850]))
                    return !1;
                if (-1 != $.inArray(e.id, [24418, 24444, 24423, 24424, 24425]))
                    return !1;
                return -1 == $.inArray(e.id, [25977, 25979, 25981, 25975, 25985, 25983, 25969, 25971, 25973, 25987, 25989]) && ((-1 == $.inArray("diary", t) || -1 === name.indexOf("Wilderness sword") && -1 === name.indexOf("Fremennik sea boots") && -1 === name.indexOf("Desert amulet") && -1 === name.indexOf("Ardougne cloak") && -1 === name.indexOf("Rada's blessing") && -1 === name.indexOf("Varrock armour") && -1 === name.indexOf("Falador shield") && -1 === name.indexOf("Morytania legs") && -1 === name.indexOf("Fremennik sea boots") && -1 === name.indexOf("Western banner") && -1 === name.indexOf("Explorer's ring") && -1 === name.indexOf("Kandarin headgear") && -1 === name.indexOf("Karamja gloves")) && ((-1 == $.inArray("f2p", t) || 1 != e.members) && ((-1 == $.inArray("ge-tradeable", t) || !0 === e.tradeable_on_ge) && (!(attStr < parseInt(130) && -1 !== name.indexOf("defender")) && ((-1 == $.inArray("third-age", t) || -1 === name.indexOf("3rd age")) && ((-1 != $.inArray("firecape", t) || "Fire cape" != name) && ((-1 != $.inArray("mythical-cape", t) || "Mythical cape" != name) && ((-1 != $.inArray("infernal-cape", t) || "Infernal cape" != name) && ((-1 != $.inArray("skillcape", t) || "Cape of Accomplishment" != name) && ((-1 != $.inArray("trimmed-skillcape", t) || "Cape of Accomplishment(t)" != name) && -1 == $.inArray(name, a)))))))))))
            }
            $(".page-gear-picker .dropdown-wrapper select").on("change", function(e) {
                if (e.preventDefault(),
                    value = $(this).val(),
                    targetId = $(this).data("id"),
                2 == $(this).find(":selected").data("hand")) {
                    $(".slot.shieldslot ul").empty(),
                        $(".slot.shieldslot").removeClass("active"),
                        $("select.shieldslot").val("select"),
                        $("select.shieldslot").attr("disabled", "disabled");
                    var t = !0
                }
                if (1 == $(this).find(":selected").data("hand")) {
                    $("select.shieldslot").removeAttr("disabled");
                    t = !1
                }
                appendId(value, targetId, t),
                    resetGearPicker(),
                    loadBossGear(),
                    setURL(value, targetId)
            }),
                $(window).on("load", function() {
                    var e = {};
                    if (decodedURL = decodeURIComponent(window.location),
                        decodeURIComponent(window.location.search).replace(/[?&]+([^=&]+)=([^&]*)/gi, function(t, a, s) {
                            e[a] = s
                        }),
                        $("body").hasClass("page-gear-picker")) {
                        if (e.twohand && (twohand = e.twohand),
                            e.headslot) {
                            value = e.headslot,
                                appendId(value, "headslot");
                            var t = !0
                        }
                        if (e.capeslot) {
                            value = e.capeslot,
                                appendId(value, "capeslot");
                            t = !0
                        }
                        if (e.neckslot) {
                            value = e.neckslot,
                                appendId(value, "neckslot");
                            t = !0
                        }
                        if (e.ammoslot) {
                            value = e.ammoslot,
                                appendId(value, "ammoslot");
                            t = !0
                        }
                        if (e.chestslot) {
                            value = e.chestslot,
                                appendId(value, "chestslot");
                            t = !0
                        }
                        if (e.weaponslot) {
                            value = e.weaponslot,
                                appendId(value, "weaponslot");
                            t = !0
                        }
                        if (e.shieldslot) {
                            value = e.shieldslot,
                                appendId(value, "shieldslot");
                            t = !0
                        }
                        if (e.legsslot) {
                            value = e.legsslot,
                                appendId(value, "legsslot");
                            t = !0
                        }
                        if (e.glovesslot) {
                            value = e.glovesslot,
                                appendId(value, "glovesslot");
                            t = !0
                        }
                        if (e.bootsslot) {
                            value = e.bootsslot,
                                appendId(value, "bootsslot");
                            t = !0
                        }
                        if (e.ringslot) {
                            value = e.ringslot,
                                appendId(value, "ringslot");
                            t = !0
                        }
                        if (e.title) {
                            value = e.title,
                                value = value.replace(/[^\w\s]/gi, ""),
                                $(".cp-gear-title h4").text(value),
                                $("#gear-title").val(value),
                                $(".cp-equipment").addClass("cp-equipment--with-title");
                            t = !0
                        }
                        1 == t && $("body").addClass("page-shared"),
                            resetBossGear(),
                            loadBossGear(),
                            url = "//www.osrsbestinslot.com/gear-picker/",
                            $("input#share-url").val(url),
                            removeModal()
                    }
                    if ($("body").hasClass("page-gear-compare")) {
                        if (e["slot-1"]) {
                            value = e["slot-1"],
                                loadCompareGear(value, "", "slot-1"),
                                appendId(value, "slot-1");
                            t = !0
                        }
                        if (e["slot-2"]) {
                            value = e["slot-2"],
                                loadCompareGear(value, "", "slot-2"),
                                appendId(value, "slot-2");
                            t = !0
                        }
                        if (e["slot-3"] && ($(".cp-gear-picker--left .offhand").attr("checked", "checked"),
                            $(".compare-row-two .slot-3").removeClass("hidden"),
                            offHand = !0,
                            value2 = e["slot-1"],
                            value = e["slot-3"],
                            loadCompareGear(value, value2, "slot-1", "slot-3", offHand),
                            appendId(value, "slot-3")),
                        e["slot-4"] && ($(".cp-gear-picker--left .offhand").attr("checked", "checked"),
                            offHand = !0,
                            $(".compare-row-two .slot-4").removeClass("hidden"),
                            value2 = e["slot-2"],
                            value = e["slot-4"],
                            loadCompareGear(value, value2, "slot-2", "slot-4", offHand),
                            appendId(value, "slot-4")),
                            e.title) {
                            value = e.title,
                                value = value.replace(/[^\w\s]/gi, ""),
                                $(".cp-gear-title h4").text(value),
                                $("#gear-title").val(value),
                                $(".cp-equipment").addClass("cp-equipment--with-title");
                            t = !0
                        }
                        1 == t && $("body").addClass("page-shared"),
                            url = "//www.osrsbestinslot.com/gear-compare/",
                            $("input#share-url").val(url),
                            removeModal()
                    }
                    $("body").hasClass("page-gear-table") && removeModal()
                }),
                $(".a--fake-click").on("click", function(e) {
                    $(this).toggleClass("a--clicked")
                }),
                $(".js-logo").each(function() {
                    var e = Math.floor(Math.random() * $(this).find("li").length + 1)
                        , t = $(this).find("li:nth-child(" + e + ")").data("src");
                    $(this).find(".js-logo--item img").attr("src", t)
                });
            var fallback3 = function(e, t, a) {
                for (var s in bisStat = 0,
                    bisName = "",
                    bisId = null,
                    e)
                    checkStats(t, e[s]) && checkExtras(e[s], extras, skips) && (parseInt(e[s].equipment.prayer) > bisStat || parseInt(e[s].equipment.prayer) == bisStat && checkAvg(e[bisIndex], e[s])) && (bisStat = e[s].equipment.prayer,
                        bisName = e[s].name,
                        bisId = e[s].id,
                        bisImg = e[s].icon,
                        bisIndex = s);
                "" !== bisName ? (slotName = e[bisId].equipment.slot,
                    $(".cp-equipment ." + slotName + " span").data("id", bisId),
                    $(".cp-equipment ." + slotName + " span").data("name", bisName),
                    $(".cp-equipment ." + slotName + " span").data("img", bisImg),
                    grabDetails(slotName),
                    console.log("[OSRS - BiS] Fallback3 Item: " + a + " for " + slotName + " is " + bisName + "(" + bisStat + ")"),
                    combatStats(e, bisIndex)) : console.log("[OSRS - BiS] Fallback Item not found for: " + a + " for " + slotName)
            }
                , fallback2 = function(e, t, a) {
                for (var s in bisStat = 0,
                    bisName = "",
                    bisId = null,
                    e)
                    checkStats(t, e[s]) && checkExtras(e[s], extras, skips) && (parseInt(e[s].equipment.defence_slash) > bisStat || parseInt(e[s].equipment.defence_slash) == bisStat && checkAvg(e[bisIndex], e[s])) && (bisStat = e[s].equipment.defence_slash,
                        bisName = e[s].name,
                        bisId = e[s].id,
                        bisImg = e[s].icon,
                        bisIndex = s);
                "" !== bisName ? (slotName = e[bisId].equipment.slot,
                    $(".cp-equipment ." + slotName + " span").data("id", bisId),
                    $(".cp-equipment ." + slotName + " span").data("name", bisName),
                    $(".cp-equipment ." + slotName + " span").data("img", bisImg),
                    grabDetails(slotName),
                    console.log("[OSRS - BiS] Fallback2 Item: " + a + " for " + slotName + " is " + bisName + "(" + bisStat + ")"),
                    combatStats(e, bisIndex)) : "ammoslot" !== e && fallback3(e, t, a)
            }
                , fallback = function(e, t, a) {
                for (var s in bisStat = 0,
                    bisName = "",
                    bisId = null,
                    e)
                    checkStats(t, e[s]) && checkExtras(e[s], extras, skips) && ("magic_damage" == a && (parseInt(e[s].equipment.attack_magic) > bisStat || parseInt(e[s].equipment.attack_magic > 0) && parseInt(e[s].equipment.attack_magic) == bisStat && checkAvg(e[bisIndex], e[s])) && (bisStat = e[s].equipment.attack_magic,
                        bisName = e[s].name,
                        bisId = e[s].id,
                        bisImg = e[s].icon,
                        bisIndex = s),
                    "ranged_strength" == a && (parseInt(e[s].equipment.attack_ranged) > bisStat || parseInt(e[s].equipment.attack_ranged > 0) && parseInt(e[s].equipment.attack_ranged) == bisStat && checkAvg(e[bisIndex], e[s])) && (bisStat = e[s].equipment.attack_ranged,
                        bisName = e[s].name,
                        bisId = e[s].id,
                        bisImg = e[s].icon,
                        bisIndex = s),
                    "strength" == a && (parseInt(e[s].equipment.defence_slash) > bisStat || parseInt(e[s].equipment.defence_slash > 0) && parseInt(e[s].equipment.defence_slash) == bisStat && checkAvg(e[bisIndex], e[s])) && (bisStat = e[s].equipment.defence_slash,
                        bisName = e[s].name,
                        bisId = e[s].id,
                        bisImg = e[s].icon,
                        bisIndex = s),
                    "stab" != a && "slash" != a && "crush" != a || (parseInt(e[s].equipment.melee_strength) > bisStat || parseInt(e[s].equipment.melee_strength) == bisStat && checkAvg(e[bisIndex], e[s])) && (bisStat = e[s].equipment.melee_strength,
                        bisName = e[s].name,
                        bisId = e[s].id,
                        bisImg = e[s].icon,
                        bisIndex = s));
                "" !== bisName ? (slotName = e[bisId].equipment.slot,
                    $(".cp-equipment ." + slotName + " span").data("id", bisId),
                    $(".cp-equipment ." + slotName + " span").data("name", bisName),
                    $(".cp-equipment ." + slotName + " span").data("img", bisImg),
                    grabDetails(slotName),
                    console.log("[OSRS - BiS] Fallback Item: " + a + " for " + slotName + " is " + bisName + "(" + bisStat + ")"),
                    combatStats(e, bisIndex)) : "ammoslot" !== slotName && fallback2(e, t, a)
            };
            function grabItem(e, t, a) {
                if (bisStat = 0,
                    bisName = "",
                    bisId = 0,
                e && "object" == typeof e && 0 !== Object.keys(e).length) {
                    if (bisIndex = Object.keys(e)[0],
                        slotName = "",
                    "undefined" != typeof ID)
                        for (var s in bisStat = null,
                            e)
                            e[s].id == ID && (bisStat = 1,
                                bisName = e[s].name,
                                bisId = e[s].id,
                                bisImg = e[s].icon,
                                bisIndex = s);
                    if ("defence" == type)
                        for (var s in e)
                            checkStats(t, e[s]) && checkExtras(e[s], extras, skips) && ("slash" == a && (parseInt(e[s].equipment.defence_slash) > bisStat || parseInt(e[s].equipment.defence_slash > 0) && parseInt(e[s].equipment.defence_slash) == bisStat && checkAvg(e[bisIndex], e[s])) && (bisStat = e[s].equipment.defence_slash,
                                bisName = e[s].name,
                                bisId = e[s].id,
                                bisImg = e[s].icon,
                                bisIndex = s),
                            "stab" == a && (parseInt(e[s].equipment.defence_stab) > bisStat || parseInt(e[s].equipment.defence_stab > 0) && parseInt(e[s].equipment.defence_stab) == bisStat && checkAvg(e[bisIndex], e[s])) && (bisStat = e[s].equipment.defence_stab,
                                bisName = e[s].name,
                                bisId = e[s].id,
                                bisImg = e[s].icon,
                                bisIndex = s),
                            "crush" == a && (parseInt(e[s].equipment.defence_crush) > bisStat || parseInt(e[s].equipment.defence_crush > 0) && parseInt(e[s].equipment.defence_crush) == bisStat && checkAvg(e[bisIndex], e[s])) && (bisStat = e[s].equipment.defence_crush,
                                bisName = e[s].name,
                                bisId = e[s].id,
                                bisImg = e[s].icon,
                                bisIndex = s),
                            "magic" == a && (parseInt(e[s].equipment.defence_magic) > bisStat || parseInt(e[s].equipment.defence_magic > 0) && parseInt(e[s].equipment.defence_magic) == bisStat && checkAvg(e[bisIndex], e[s])) && (bisStat = e[s].equipment.defence_magic,
                                bisName = e[s].name,
                                bisId = e[s].id,
                                bisImg = e[s].icon,
                                bisIndex = s),
                            "ranged" == a && (parseInt(e[s].equipment.defence_ranged) > bisStat || parseInt(e[s].equipment.defence_ranged > 0) && parseInt(e[s].equipment.defence_ranged) == bisStat && checkAvg(e[bisIndex], e[s])) && (bisStat = e[s].equipment.defence_ranged,
                                bisName = e[s].name,
                                bisId = e[s].id,
                                bisImg = e[s].icon,
                                bisIndex = s));
                    if ("offence" == type)
                        for (var s in e)
                            checkStats(t, e[s]) && checkExtras(e[s], extras, skips) && ("slash" == a && (parseInt(e[s].equipment.attack_slash) > bisStat || e[s].equipment.attack_slash > 0 && parseInt(e[s].equipment.attack_slash) == bisStat && checkAvg(e[bisIndex], e[s])) && (bisStat = e[s].equipment.attack_slash,
                                bisName = e[s].name,
                                bisId = e[s].id,
                                bisImg = e[s].icon,
                                bisIndex = s),
                            "stab" == a && (parseInt(e[s].equipment.attack_stab) > bisStat || e[s].equipment.attack_stab > 0 && parseInt(e[s].equipment.attack_stab) == bisStat && checkAvg(e[bisIndex], e[s])) && (bisStat = e[s].equipment.attack_stab,
                                bisName = e[s].name,
                                bisId = e[s].id,
                                bisImg = e[s].icon,
                                bisIndex = s),
                            "crush" == a && (parseInt(e[s].equipment.attack_crush) > bisStat || e[s].equipment.attack_crush > 0 && parseInt(e[s].equipment.attack_crush) == bisStat && checkAvg(e[bisIndex], e[s])) && (bisStat = e[s].equipment.attack_crush,
                                bisName = e[s].name,
                                bisId = e[s].id,
                                bisImg = e[s].icon,
                                bisIndex = s),
                            "magic" == a && (parseInt(e[s].equipment.attack_magic) > bisStat || parseInt(e[s].equipment.attack_magic > 0) && parseInt(e[s].equipment.attack_magic) == bisStat && checkAvg(e[bisIndex], e[s])) && (bisStat = e[s].equipment.attack_magic,
                                bisName = e[s].name,
                                bisId = e[s].id,
                                bisImg = e[s].icon,
                                bisIndex = s),
                            "ranged" == a && (parseInt(e[s].equipment.attack_ranged) > bisStat || parseInt(e[s].equipment.attack_ranged > 0) && parseInt(e[s].equipment.attack_ranged) == bisStat && checkAvg(e[bisIndex], e[s])) && (bisStat = e[s].equipment.attack_ranged,
                                bisName = e[s].name,
                                bisId = e[s].id,
                                bisImg = e[s].icon,
                                bisIndex = s));
                    if ("others" == type)
                        for (var s in e)
                            checkStats(t, e[s]) && checkExtras(e[s], extras, skips) && ("strength" == a && (parseInt(e[s].equipment.melee_strength) == bisStat && checkAvg(e[bisIndex], e[s]) && (bisStat = e[s].equipment.melee_strength,
                                bisName = e[s].name,
                                bisId = e[s].id,
                                bisImg = e[s].icon,
                                bisIndex = s),
                            (parseInt(e[s].equipment.melee_strength) > bisStat || parseInt(e[s].equipment.melee_strength > 0) && parseInt(e[s].equipment.melee_strength) == bisStat && checkAvg(e[bisIndex], e[s])) && (bisStat = e[s].equipment.melee_strength,
                                bisName = e[s].name,
                                bisId = e[s].id,
                                bisImg = e[s].icon,
                                bisIndex = s)),
                            "ranged_strength" == a && (parseInt(e[s].equipment.ranged_strength) > bisStat || parseInt(e[s].equipment.ranged_strength > 0) && parseInt(e[s].equipment.ranged_strength) == bisStat && checkAvg(e[bisIndex], e[s])) && (bisStat = e[s].equipment.ranged_strength,
                                bisName = e[s].name,
                                bisId = e[s].id,
                                bisImg = e[s].icon,
                                bisIndex = s),
                            "magic_damage" == a && (parseInt(e[s].equipment.magic_damage) > bisStat || parseInt(e[s].equipment.magic_damage > 0) && parseInt(e[s].equipment.magic_damage) == bisStat && checkAvg(e[bisIndex], e[s])) && (bisStat = e[s].equipment.magic_damage,
                                bisName = e[s].name,
                                bisId = e[s].id,
                                bisImg = e[s].icon,
                                bisIndex = s),
                            "prayer" == a && (parseInt(e[s].equipment.prayer) > bisStat || parseInt(e[s].equipment.prayer > 0) && parseInt(e[s].equipment.prayer) == bisStat && checkAvg(e[bisIndex], e[s])) && (bisStat = e[s].equipment.prayer,
                                bisName = e[s].name,
                                bisId = e[s].id,
                                bisImg = e[s].icon,
                                bisIndex = s));
                    0 == bisStat ? fallback(e, t, a) : "" !== bisName && (slotName = e[bisId].equipment.slot,
                        console.log(e[bisId]),
                        $(".cp-equipment ." + slotName + " span").data("id", bisId),
                        $(".cp-equipment ." + slotName + " span").data("name", bisName),
                        $(".cp-equipment ." + slotName + " span").data("img", bisImg),
                        combatStats(e, bisIndex),
                        console.log("[OSRS - BiS] BiS Item: " + a + " for " + slotName + " is " + bisName + "(" + bisStat + ")"),
                        grabDetails(slotName)),
                        "ranged" != a && "ranged_strength" != a || "weapon" != slotName && "2h" != slotName || "offence" != type && "others" != type || null == ammo_requirements[bisIndex] ? "weapon" != slotName && "2h" != slotName || grabPrayer(e, bisIndex, skips) : grabAmmo(e, bisIndex)
                }
            }
            function grabAmmo(e, t) {
                if (null != ammo_requirements[t]) {
                    for (var a in bisStat = 0,
                        bisName = "",
                        bisId = 0,
                        bisIndex = 0,
                        slotName = "ammoslot",
                        bisStat = 0,
                        ammoType = "",
                        ammoTier = ammo_requirements[t].ammo_tier,
                        console.log("[OSRS - BiS] BiS Item: Weapon Type is " + ammo_requirements[t].weapon_type),
                    "Crossbow" == ammo_requirements[t].weapon_type && (ammoType = "bolts"),
                    "Karils" == ammo_requirements[t].weapon_type && (ammoType = "bolt racks"),
                    "Bone" == ammo_requirements[t].weapon_type && (ammoType = "bone"),
                    "Ogre Bow" == ammo_requirements[t].weapon_type && (ammoType = "ogre"),
                    "Ogre Comp" == ammo_requirements[t].weapon_type && (ammoType = "brutals"),
                    "Hunters Crossbow" == ammo_requirements[t].weapon_type && (ammoType = "kebbits"),
                    "Longbow" == ammo_requirements[t].weapon_type && (ammoType = "arrows"),
                    "Shortbow" == ammo_requirements[t].weapon_type && (ammoType = "arrows"),
                    "Ballista" == ammo_requirements[t].weapon_type && (ammoType = "javelins"),
                        ammo_requirements)
                        null !== ammo_requirements[a] && "" !== ammoType && ammoType == ammo_requirements[a].ammo_type && parseInt(ammoslot[a].equipment.ranged_strength) > bisStat && checkExtras(ammoslot[a], extras, skips) && (null == ammoTier || ammoTier >= ammo_requirements[a].ammo_tier) && (bisStat = ammoslot[a].equipment.ranged_strength,
                            bisName = ammoslot[a].name,
                            bisId = ammoslot[a].id,
                            bisImg = ammoslot[a].icon,
                            bisIndex = a);
                    if ("" == ammoType)
                        for (var a in ammoslot)
                            (parseInt(ammoslot[a].equipment.prayer) > bisStat || parseInt(ammoslot[a].equipment.prayer > 0) && parseInt(ammoslot[a].equipment.prayer) == bisStat && checkAvg(ammoslot[bisIndex], e[a])) && (bisStat = ammoslot[a].equipment.prayer,
                                bisName = ammoslot[a].name,
                                bisId = ammoslot[a].id,
                                bisImg = ammoslot[a].icon,
                                bisIndex = a);
                    "" !== ammoType && ($(".cp-equipment ." + slotName + " span").data("id", bisId),
                        $(".cp-equipment ." + slotName + " span").data("name", bisName),
                        $(".cp-equipment ." + slotName + " span").data("img", bisImg),
                        combatStats(ammoslot, bisIndex),
                        console.log("[OSRS - BiS] BiS Item: " + stat + " for " + slotName + " is " + bisName + "(" + bisStat + ")")),
                    "" !== bisName && grabDetails(slotName)
                }
            }
            function grabPrayer(e, t) {
                for (var a in bisStat = 0,
                    bisName = "",
                    bisId = 0,
                    bisIndex = 0,
                    slotName = "ammoslot",
                    bisStat = 0,
                    ammoslot)
                    checkStats(stats, ammoslot[a]) && checkExtras(ammoslot[a], extras, skips) && (parseInt(ammoslot[a].equipment.prayer) > bisStat || parseInt(ammoslot[a].equipment.prayer > 0)) && (bisStat = ammoslot[a].equipment.prayer,
                        bisName = ammoslot[a].name,
                        bisId = ammoslot[a].id,
                        bisImg = ammoslot[a].icon,
                        bisIndex = a);
                $(".cp-equipment ." + slotName + " span").data("id", bisId),
                    $(".cp-equipment ." + slotName + " span").data("name", bisName),
                    $(".cp-equipment ." + slotName + " span").data("img", bisImg),
                    console.log("[OSRS - BiS] BiS Item: " + stat + " for " + slotName + " is " + bisName + "(" + bisStat + ")"),
                "" !== bisName && (combatStats(ammoslot, bisIndex),
                    grabDetails(slotName))
            }
            function grabDetails(e) {
                target = $(".cp-equipment ." + slotName),
                    itemID = target.children("span").data("id"),
                    itemImg = target.children("span").data("img"),
                    name = target.children("span").data("name"),
                    nameStripped = name.toLowerCase().replace(/[^a-z0-9\s]/gi, "").replace(/ /g, "_"),
                    img = "<img src='data:image/png;base64," + itemImg + "'>",
                    $(target).append(img),
                    $(target).find(".slot-name").html(name),
                    $(".cp-equipment ." + slotName).addClass("active")
            }
            $i = 0;
            var skips = []
                , slotSkips = [];
            function reset() {
                $(".cp-equipment .slot").children("img").remove(),
                    $(".cp-equipment .slot").removeClass("active"),
                    $(".cp-equipment .slot span").data("id", ""),
                    $(".cp-equipment .slot span").data("name", ""),
                    $(".combat-stats .value").html("0")
            }
            function setDefaults(e, t, a) {
                t.hasClass("attack-style") ? (e.preventDefault(),
                    $(".attack-style").removeClass("active"),
                    t.addClass("active"),
                $(".one-hand").hasClass("active") || $(".two-hand").hasClass("active") || $(".one-hand").addClass("active")) : t.hasClass("weapon-style") ? (e.preventDefault(),
                    $(".weapon-style").removeClass("active"),
                    t.addClass("active"),
                $(".attack-style").hasClass("active") || $(".attack-style").first().addClass("active")) : t.hasClass("slot-prev") ? (skipItem = t.parents(".slot").children("span").first().data("name"),
                    a.push(skipItem),
                    (slotSkips = null == t.data("slot-skips") ? [] : t.data("slot-skips")).push(skipItem),
                    t.data("slot-skips", slotSkips),
                    slotSkipArray = t.data("slot-skips"),
                    t.parents(".slot").find(".slot-next").removeClass("hide")) : t.hasClass("slot-next") && (targetSlot = t.parents(".slot").find(".slot-prev"),
                    targetSlotArray = targetSlot.data("slot-skips"),
                    lastSkipped = targetSlotArray[targetSlotArray.length - 1],
                    console.log(targetSlotArray),
                    a.splice($.inArray(lastSkipped, a), 1),
                    targetSlotArray.splice($.inArray(lastSkipped, a), 1),
                    targetSlot.data("slot-skips", targetSlotArray),
                "" == targetSlot.data("slot-skips") && t.addClass("hide"))
            }
            function setExtras() {
                $(".option").each(function() {
                    target = $(this).find("input"),
                    target.is(":checked") && (value = $(target).data("option"),
                        extras.push(value))
                })
            }
            $(".attack-style, .weapon-style, .option").on("click", function(e) {
                skips = []
            }),
                $(".page-best-in-slot-gear .attack-style, .page-best-in-slot-gear .weapon-style, .page-best-in-slot-gear .option, .page-best-in-slot-gear .slot-prev, .page-best-in-slot-gear .slot-next ").on("click", function(e) {
                    if (extras = [],
                        clicked = $(this),
                        window.osrsbisTrack)
                        if (clicked.hasClass("attack-style"))
                            osrsbisTrack("attack_style_select", {
                                tool: "bis_calculator",
                                style: (clicked.data("ot") || "").toString()
                            });
                        else if (clicked.find("input[type=checkbox]").length || clicked.hasClass("option")) {
                            var t = clicked.find("input[type=checkbox]");
                            osrsbisTrack("extras_toggle", {
                                tool: "bis_calculator",
                                option: (t.data("option") || "").toString(),
                                state: t.is(":checked") ? "on" : "off"
                            })
                        }
                    var a;
                    if (setDefaults(e, clicked, skips),
                        setExtras(extras),
                        reset(),
                        target = $(".style").find(".active"),
                        target.length) {
                        type = $(target).parents(".style").data("attack-style"),
                            stat = ($(target).data("ot") || "").replace(/ /g, "_"),
                            hand = $(".weapon.wrapper").find(".active").data("slot");
                        var s = function(e) {
                            return e = parseInt(e, 10),
                                isNaN(e) || e < 1 ? 1 : e > 99 ? 99 : e
                        };
                        att = s($(".cp-stats__stat.attack").find(".cp-stats__stat-number").val()),
                            str = s($(".cp-stats__stat.strength").find(".cp-stats__stat-number").val()),
                            def = s($(".cp-stats__stat.defence").find(".cp-stats__stat-number").val()),
                            hp = s($(".cp-stats__stat.hitpoints").find(".cp-stats__stat-number").val()),
                            ranged = s($(".cp-stats__stat.ranged").find(".cp-stats__stat-number").val()),
                            magic = s($(".cp-stats__stat.magic").find(".cp-stats__stat-number").val()),
                            prayer = s($(".cp-stats__stat.prayer").find(".cp-stats__stat-number").val()),
                            stats = {
                                att: att,
                                str: str,
                                def: def,
                                hp: hp,
                                ranged: ranged,
                                magic: magic,
                                prayer: prayer,
                                type: type,
                                hand: hand,
                                members: !1
                            },
                            grabItem(glovesslot, stats, stat, extras, skips, a),
                            grabItem(capeslot, stats, stat, extras, skips, a),
                            grabItem(neckslot, stats, stat, extras, skips, a),
                            grabItem(ringslot, stats, stat, extras, skips, a),
                            grabItem(bootsslot, stats, stat, extras, skips, a),
                            grabItem(headslot, stats, stat, extras, skips, a),
                            grabItem(chestslot, stats, stat, extras, skips, a),
                            grabItem(legsslot, stats, stat, extras, skips, a),
                        1 == hand && (grabItem(weaponslot, stats, stat, extras, skips, a),
                            grabItem(shieldslot, stats, stat, extras, skips, a)),
                        2 == hand && grabItem(weaponslot, stats, stat, extras, skips, a),
                            console.log(stats)
                    }
                });
            var removeModal = function() {
                $(".modal-overlay").remove(),
                    $(".modal").remove()
            };
            function itemLookup(target) {
                if (targetModal.removeClass("error"),
                    $("main .more-info-backdrop").addClass("active"),
                    targetModal.addClass("active"),
                    targetModal.addClass("loading"),
                    targetModal.find(".more-info-price").addClass("loading"),
                    $(target).hasClass("active")) {
                    if ($("body").hasClass("page-gear-table")) {
                        lookupID = $(target).children(".slot").children("span").data("id"),
                            lookupName = $(target).children(".slot").children("span").data("name"),
                            lookupImg = $(target).find("img").attr("src");
                        var slot = target.data("slot")
                            , slot = eval(slot)
                    } else {
                        lookupID = $(target).children("span").data("id"),
                            lookupName = $(target).children("span").data("name"),
                            lookupImg = $(target).children("img").attr("src");
                        var slot = target.attr("class").split(" ")
                            , slot = eval(slot[1])
                    }
                    console.log(slot[lookupID]);
                    var data = slot[lookupID];
                    if (!data)
                        return targetModal.removeClass("loading").addClass("error"),
                            void targetModal.find("h2").html("Item not available");
                    if (targetModal.removeClass("loading"),
                        targetModal.find("h2").html(data.name),
                        targetModal.find(".members-item").html(boolToString(data.members)),
                        targetModal.find(".tradeable").html(boolToString(data.tradeable)),
                    0 == data.equipable && targetModal.find(".more-info-stats").hide(),
                        data.tradeable,
                    0 == data.tradeable && 0 == data.equipable && targetModal.removeClass("big").removeClass("small").addClass("tiny"),
                    0 == data.equipable && 1 == data.tradeable && targetModal.removeClass("big").removeClass("tiny").addClass("small"),
                    1 == data.equipable) {
                        targetModal.removeClass("small").removeClass("tiny").addClass("big"),
                            targetModal.find(".more-info-stats").show();
                        var attack = "<span class='textleft'>Stab : </span><span class='textright'>" + data.equipment.attack_stab + "</span><br/><span class='textleft'>Slash : </span><span class='textright'>" + data.equipment.attack_slash + "</span><br/><span class='textleft'>Crush : </span><span class='textright'>" + data.equipment.attack_crush + "</span><br/><span class='textleft'>Magic : </span><span class='textright'>" + data.equipment.attack_magic + "</span><br/><span class='textleft'>Ranged : </span><span class='textright'>" + data.equipment.attack_ranged + "</span><br/>"
                            , attack_table = "<table class='osrstooltip-table'><tr><th colspan='5'>Attack Bonus</th></tr><tr><td><img src='/wp-content/themes/osrs-bis/img/icons/combat/stab.png' alt=''></td><td><img src='/wp-content/themes/osrs-bis/img/icons/combat/slash.png' alt=''></td><td><img src='/wp-content/themes/osrs-bis/img/icons/combat/crush.png' alt=''></td><td><img src='/wp-content/themes/osrs-bis/img/icons/combat/magic.png' alt=''></td><td><img src='/wp-content/themes/osrs-bis/img/icons/combat/ranged.png' alt=''></td></tr><tr><td>" + data.equipment.attack_stab + "</td><td>" + data.equipment.attack_slash + "</td><td>" + data.equipment.attack_crush + "</td><td>" + data.equipment.attack_magic + "</td><td>" + data.equipment.attack_ranged + "</td></tr>"
                            , defence_table = "<tr><th colspan='5'>Defence Bonus</th></tr><tr><td><img src='/wp-content/themes/osrs-bis/img/icons/combat/stab.png' alt=''></td><td><img src='/wp-content/themes/osrs-bis/img/icons/combat/slash.png' alt=''></td><td><img src='/wp-content/themes/osrs-bis/img/icons/combat/crush.png' alt=''></td><td><img src='/wp-content/themes/osrs-bis/img/icons/combat/magic.png' alt=''></td><td><img src='/wp-content/themes/osrs-bis/img/icons/combat/ranged.png' alt=''></td></tr><tr><td>" + data.equipment.defence_stab + "</td><td>" + data.equipment.defence_slash + "</td><td>" + data.equipment.defence_crush + "</td><td>" + data.equipment.defence_magic + "</td><td>" + data.equipment.defence_ranged + "</td></tr>"
                            , other_bonuses_table = "<tr><th colspan='4'>Other Bonuses</th></tr><tr><td><img src='/wp-content/themes/osrs-bis/img/icons/combat/strength.png' alt=''></td><td><img src='/wp-content/themes/osrs-bis/img/icons/combat/ranged-strength.png' alt=''></td><td><img src='/wp-content/themes/osrs-bis/img/icons/combat/magic-damage.png' alt=''></td><td><img src='/wp-content/themes/osrs-bis/img/icons/combat/prayer.png' alt=''></td></tr><tr><td>" + data.equipment.melee_strength + "</td><td>" + data.equipment.ranged_strength + "</td><td>" + data.equipment.magic_damage + "</td><td>" + data.equipment.prayer + "</td></tr></table>";
                        targetModal.find(".more-info-stats").html(attack_table + defence_table + other_bonuses_table)
                    }
                    function geTracker() {
                        data.probemas ? (targetModal.addClass("error"),
                            targetModal.find(".more-info-price").addClass("hide"),
                            targetModal.find(".cp-button").attr("href", data.probemas + "?utm_source=osrs-bis&utm_medium=view-gear"),
                            targetModal.find(".cp-button").text("Buy on Probemas"),
                            targetModal.find("img.item-img").attr("src", lookupImg),
                            targetModal.find(".more-info-cta").removeClass("hide")) : $.ajax({
                            url: "https://www.osrsbestinslot.com/api/getTrackerItems.php",
                            data: {
                                id: lookupID
                            },
                            dataType: "JSON",
                            success: function(e) {
                                console.log(e),
                                    targetModal.find(".item-img").removeClass("hide"),
                                    targetModal.find(".more-info-price").removeClass("loading"),
                                    targetModal.find(".more-info-price").removeClass("hide"),
                                    itemPrice = e.data.selling,
                                    itemUpdated = e.data.updatedAt,
                                    itemUpdated = new Date(itemUpdated.replace(/-/g, "/")),
                                    itemUpdated = itemUpdated.setHours(itemUpdated.getHours() + 1),
                                    itemUrl = e.data.url,
                                    itemImg = e.data.icon,
                                    0 !== itemPrice ? targetModal.find(".price").html(convertToK(itemPrice)) : targetModal.find(".price").html("item not actively traded."),
                                    targetModal.find(".updated").html(timeSince(itemUpdated) + " ago"),
                                    targetModal.find("img.item-img").attr("src", lookupImg),
                                    targetModal.find(".cp-button").attr("href", itemUrl + "?ref=osrsbestinslot"),
                                    targetModal.find(".cp-button").text("View on GE Tracker"),
                                    targetModal.find(".more-info-cta").removeClass("hide")
                            },
                            error: function(e) {
                                itemUrl = "https://www.ge-tracker.com/item/" + lookupID,
                                    targetModal.addClass("error"),
                                    targetModal.find(".more-info-price").addClass("hide"),
                                    targetModal.find(".cp-button").attr("href", itemUrl + "?ref=osrsbestinslot"),
                                    targetModal.find(".cp-button").text("View on GE Tracker"),
                                    targetModal.find("img.item-img").attr("src", lookupImg)
                            }
                        })
                    }
                    function checkUnTradeables() {
                        25486 == lookupID && (lookupID = 28313,
                            geTracker()),
                            25487 == lookupID ? (lookupID = 28310,
                                geTracker()) : 25485 == lookupID ? (lookupID = 28307,
                                geTracker()) : 19710 == lookupID ? (lookupID = 19550,
                                geTracker()) : 11771 == lookupID ? (lookupID = 6733,
                                geTracker()) : 11773 == lookupID ? (lookupID = 6737,
                                geTracker()) : 21752 == lookupID ? (lookupID = 21739,
                                geTracker()) : 13202 == lookupID ? (lookupID = 12601,
                                geTracker()) : 11770 == lookupID ? (lookupID = 6731,
                                geTracker()) : 12692 == lookupID ? (lookupID = 12605,
                                geTracker()) : 12691 == lookupID ? (lookupID = 12603,
                                geTracker()) : 11772 == lookupID ? (lookupID = 6735,
                                geTracker()) : 22322 == lookupID ? (lookupID = 22477,
                                geTracker()) : 12931 == lookupID || 13197 == lookupID || 13199 == lookupID ? (lookupID = 12927,
                                geTracker()) : 12006 == lookupID ? (lookupID = 4151,
                                geTracker()) : 11865 == lookupID || 11864 == lookupID || 11784 == lookupID ? (lookupID = 8921,
                                geTracker()) : (targetModal.find("img.item-img").attr("src", lookupImg),
                                targetModal.find(".item-img").removeClass("hide"),
                                targetModal.find(".more-info-price").addClass("hide"),
                                targetModal.find(".more-info-cta").addClass("hide"))
                    }
                    console.log(data.probemas),
                        1 == data.tradeable ? data.probemas ? (targetModal.addClass("error"),
                            targetModal.find(".more-info-price").addClass("hide"),
                            targetModal.find(".cp-button").attr("href", data.probemas + "?utm_source=osrs-bis&utm_medium=view-gear"),
                            targetModal.find(".cp-button").text("Buy on Probemas"),
                            targetModal.find("img.item-img").attr("src", lookupImg),
                            targetModal.find(".more-info-cta").removeClass("hide")) : (geTracker(),
                            targetModal.addClass("error"),
                            targetModal.find(".more-info-price").addClass("hide"),
                            targetModal.find(".cp-button").attr("href", "https://www.ge-tracker.com/item/" + lookupID + "?ref=osrsbestinslot"),
                            targetModal.find(".cp-button").text("View on GE Tracker"),
                            targetModal.find("img.item-img").attr("src", lookupImg),
                            targetModal.find(".more-info-cta").removeClass("hide")) : checkUnTradeables()
                }
                function boolToString(e) {
                    return 1 == e ? "True" : "False"
                }
            }
            $(".more-info .close").on("click", function(e) {
                e.preventDefault(),
                    $(this).parents(".more-info").removeClass("active"),
                    $(this).parents(".more-info").addClass("loading"),
                    $(this).parents(".more-info").removeClass("error"),
                    $(this).parents(".more-info").find(".more-info-price").addClass("loading"),
                    $(this).parents(".more-info").find(".item-img").attr("src", "https://chisel.weirdgloop.org/static/img/osrs-sprite/291.png"),
                    $("main .more-info-backdrop").removeClass("active")
            }),
                $(".screenshot-modal .close").on("click", function(e) {
                    e.preventDefault(),
                        $(this).parents(".screenshot-modal").find("h2").text("Generating Screenshot"),
                        $(this).parents(".screenshot-modal").removeClass("active"),
                        $(this).parents(".screenshot-modal").addClass("loading"),
                        $(this).parents(".screenshot-modal-backdrop").removeClass("active"),
                        $(this).parents(".screenshot-modal").find("img").remove()
                }),
                $(document).on("click", ".show-info", function(e) {
                    if (e.preventDefault(),
                        $("body").hasClass("page-gear-table") ? target = $(this).parents(".cp-gear-table__item") : target = $(this).parents(".slot"),
                        window.osrsbisTrack) {
                        var t = target.find("span[data-id]").first();
                        osrsbisTrack("more_info_open", {
                            item_id: (t.data("id") || "").toString(),
                            item_name: (t.data("name") || "").toString()
                        })
                    }
                    targetModal = $("main .more-info"),
                        itemLookup(target, targetModal)
                }),
                $(".cp-header__nav-toggle, .menu-close").on("click", function(e) {
                    e.preventDefault(),
                        $(".cp-header__nav-toggle--text").toggleText("Menu", "Close"),
                        $(".cp-header__navigation").toggleClass("cp-header__navigation--open")
                }),
                $.fn.extend({
                    toggleText: function(e, t) {
                        return this.text(this.text() == t ? e : t)
                    }
                });
            var controllerParallax = new ScrollMagic.Controller({
                globalSceneOptions: {
                    triggerHook: "onLeave",
                    duration: "100%"
                }
            })
                , controllerParallax2 = new ScrollMagic.Controller({
                globalSceneOptions: {
                    triggerHook: "onLeave",
                    duration: "200%"
                }
            })
                , controllerParallax3 = new ScrollMagic.Controller({
                globalSceneOptions: {
                    triggerHook: "onLeave",
                    duration: "100%"
                }
            });
            new ScrollMagic.Scene({
                triggerElement: ".cp-header__masthead"
            }).setTween(".cp-header__masthead", {
                y: "40%",
                ease: Linear.easeOut
            }).addTo(controllerParallax),
                $("[class*=h-translate__y]").each(function() {
                    console.log("hello"),
                        new ScrollMagic.Scene({
                            triggerElement: ".cp-header__masthead"
                        }).setTween(this, {
                            y: "0",
                            ease: Linear.easeInOut
                        }).addTo(controllerParallax3)
                }),
                $("[class*=h-translate__x]").each(function() {
                    new ScrollMagic.Scene({
                        triggerElement: ".cp-header__masthead"
                    }).setTween(this, {
                        x: "0",
                        ease: Linear.easeInOut
                    }).addTo(controllerParallax3)
                });
            var $lCenter = $(".l-center")
                , stickySidebar = $lCenter.length && $lCenter.offset() ? $lCenter.offset().top : 0;
            $(window).scroll(function() {
                stickySidebar && ($(window).scrollTop() > stickySidebar - 80 ? $(".cp-header__nav-wrapper").addClass("l-sticky") : $(".cp-header__nav-wrapper").removeClass("l-sticky"))
            }),
                $(".cp-search__search-submit").click(function(e) {
                    e.preventDefault();
                    var t = $(".cp-search__search-input").val()
                        , a = t.replace(" ", "_");
                    if ("" !== a) {
                        window.osrsbisTrack && osrsbisTrack("rsn_search", {
                            tool: -1 !== document.body.className.indexOf("page-gear-table") ? "gear_table" : "bis_calculator"
                        });
                        $.ajax({
                            url: "https://www.osrsbestinslot.com/api/getStats.php?lowercase=yes",
                            data: {
                                user: a
                            },
                            dataType: "json",
                            type: "GET",
                            success: function(e) {
                                if (console.log(e),
                                !e || !e.skills)
                                    return $(".cp-search__search-error").addClass("active"),
                                        void $(".cp-search__search-error").html("No stats returned for " + t);
                                Object.keys(e.skills).forEach(function(t) {
                                    $(".cp-stats__stat").each(function() {
                                        $(this).data("stat") == t && ($(this).find(".cp-stats__stat-number").val(e.skills[t].level),
                                        99 == e.skills[t].level && i++)
                                    })
                                }),
                                    $(".cp-search__search-error").addClass("active"),
                                    $(".cp-search__search-error").html("Stats pulled for " + t),
                                    1 == i ? $("#skillcape").attr("checked", "checked") : i > 1 && ($("#skillcape").attr("checked", "checked"),
                                        $("#trimmed-skillcape").attr("checked", "checked"))
                            },
                            error: function(e, a) {
                                $(".cp-search__search-error").addClass("active"),
                                    $(".cp-search__search-error").html("FAILED to retrieve stats for " + t)
                            }
                        })
                    } else
                        $(".cp-search__search-error").addClass("active"),
                            $(".cp-search__search-error").html("Enter a username above.")
                });
            var setURL = function(e, t, a) {
                a && (t = a);
                var s = $("input#share-url");
                if (s.length) {
                    var n = s.val() || "";
                    newURL = "",
                        baseURL = s.data("base"),
                        -1 != n.indexOf("?") ? (urlSplit = n.split("?"),
                            parameterSplit = urlSplit[1].split("&"),
                            $.each(parameterSplit, function(e, a) {
                                if (-1 != a.indexOf(t))
                                    return parameterSplit.splice(e),
                                        !1
                            }),
                            parameterSplit.push(t + "=" + e),
                            $.each(parameterSplit, function(e, t) {
                                connector = 0 == e ? "?" : "&",
                                    newURL += connector + t
                            })) : newURL = "?" + t + "=" + e,
                        newURL = baseURL + newURL,
                        console.log(newURL),
                        $("input#share-url").val(newURL)
                }
            };
            function clampStat(e) {
                return e = parseInt(e, 10),
                    isNaN(e) || e < 1 ? 1 : e > 99 ? 99 : e
            }
            function tweakValues(e) {
                e.preventDefault();
                var t = clampStat($(this).siblings(".cp-stats__stat-number").val());
                $(this).hasClass("cp-stats__controls--increment") ? t < 99 && t++ : t > 1 && t--,
                    $(this).siblings(".cp-stats__stat-number").val(t)
            }
            !function() {
                "use strict";
                var e = document.getElementById("skill-calc");
                if (e) {
                    var t = e.getAttribute("data-methods-url") || ""
                        , a = window.OSRS_XP_TABLE || {}
                        , s = {
                        skills: o("skill-grid"),
                        curLevel: o("skill-current-level"),
                        curXp: o("skill-current-xp"),
                        tgtLevel: o("skill-target-level"),
                        tgtXp: o("skill-target-xp"),
                        result: o("skill-calc-result")
                    }
                        , n = {}
                        , i = []
                        , r = null;
                    "loading" === document.readyState ? document.addEventListener("DOMContentLoaded", b) : b()
                }
                function o(e) {
                    return document.getElementById(e)
                }
                function l(e) {
                    return null == e || isNaN(e) ? "—" : Math.round(e).toLocaleString("en-US")
                }
                function c(e) {
                    return e.charAt(0).toUpperCase() + e.slice(1)
                }
                function d(e) {
                    return "https://oldschool.runescape.wiki/images/" + c(e) + "_icon.png"
                }
                function m(e) {
                    return e <= 1 ? 0 : (e > 126 && (e = 126),
                    a[e] || 0)
                }
                function p(e) {
                    for (var t = 1, s = 1; s <= 126 && (void 0 !== a[s] && a[s] <= e); s++)
                        t = s;
                    return t
                }
                function u(e) {
                    return isFinite(e) ? e < 1 ? Math.max(1, Math.round(60 * e)) + "m" : e < 100 ? e.toFixed(1) + "h" : Math.round(e) + "h" : "—"
                }
                function g(e) {
                    r = e;
                    for (var t = s.skills.querySelectorAll(".cp-skill-btn"), a = 0; a < t.length; a++)
                        t[a].classList.toggle("is-active", t[a].getAttribute("data-skill") === e);
                    h()
                }
                function h() {
                    if (s.result)
                        if (r) {
                            var e = "" !== s.curXp.value ? parseInt(s.curXp.value, 10) : null
                                , t = parseInt(s.curLevel.value, 10)
                                , a = "" !== s.tgtXp.value ? parseInt(s.tgtXp.value, 10) : null
                                , i = parseInt(s.tgtLevel.value, 10)
                                , o = null === e || isNaN(e) ? m(t) : e
                                , d = null === a || isNaN(a) ? m(i) : a
                                , g = d - o;
                            if (g <= 0)
                                s.result.innerHTML = '<p class="cp-skill-done">You&rsquo;re already there! 🎉</p><p class="cp-skill-empty">Set a higher target level or XP to plan your next goal.</p>';
                            else {
                                for (var h = p(o), b = p(d), f = d > 0 ? Math.max(0, Math.min(100, o / d * 100)) : 0, v = '<div class="cp-skill-xp">' + l(g) + '<small>XP to go</small></div><p class="cp-skill-route">Level <b>' + h + "</b> &rarr; <b>" + b + "</b> in " + c(r) + '</p><div class="cp-skill-bar"><i style="width:' + f.toFixed(1) + '%"></i></div>', k = n[r] || [], I = [], $ = 0; $ < k.length; $++)
                                    k[$].level <= h && I.push(k[$]);
                                if (I.sort(function(e, t) {
                                    return t.xp_hour - e.xp_hour
                                }),
                                    !I.length)
                                    return v += '<p class="cp-skill-empty">No methods unlocked at level ' + h + " yet. Raise your current level to reveal training options.</p>",
                                        void (s.result.innerHTML = v);
                                v += '<p class="cp-skill-mhead">Best methods at level ' + h + "</p>";
                                for (var S = 0; S < I.length; S++) {
                                    var _ = I[S]
                                        , x = g / _.xp_hour
                                        , y = x * (_.cost_per_hour || 0)
                                        , q = l(_.xp_hour) + " XP/hr &middot; " + (y ? l(y) + " gp" : "free");
                                    v += '<div class="cp-skill-method' + (0 === S ? " is-fast" : "") + '"><div><div class="cp-skill-method-name">' + _.method + (0 === S ? '<span class="tag">Fastest</span>' : "") + '</div><div class="cp-skill-method-sub">' + q + '</div></div><div class="cp-skill-method-time"><b>' + u(x) + "</b><span>to goal</span></div></div>"
                                }
                                s.result.innerHTML = v
                            }
                        } else
                            s.result.innerHTML = '<p class="cp-skill-empty">Pick a skill to begin.</p>'
                }
                function b() {
                    t && fetch(t, {
                        credentials: "omit"
                    }).then(function(e) {
                        return e.json()
                    }).then(function(e) {
                        n = e || {},
                            i = Object.keys(n),
                            function() {
                                if (s.skills) {
                                    for (var e = "", t = 0; t < i.length; t++) {
                                        var a = i[t];
                                        e += '<button type="button" class="cp-skill-btn" role="tab" data-skill="' + a + '"><img src="' + d(a) + '" alt="" loading="lazy"><span>' + c(a) + "</span></button>"
                                    }
                                    s.skills.innerHTML = e
                                }
                            }(),
                            s.skills.addEventListener("click", function(e) {
                                var t = e.target.closest(".cp-skill-btn");
                                t && g(t.getAttribute("data-skill"))
                            }),
                            [s.curLevel, s.curXp, s.tgtLevel, s.tgtXp].forEach(function(e) {
                                e && e.addEventListener("input", h)
                            }),
                        i.length && g(i[0])
                    }).catch(function() {
                        s.skills && (s.skills.innerHTML = '<div class="cp-skill-loading">Could not load skill data. Refresh to try again.</div>')
                    })
                }
            }(),
                $(".cp-stats__controls").on("click", tweakValues),
                $(".cp-stats__stat-number").on("change blur", function() {
                    $(this).val(clampStat($(this).val()))
                })
        })
    }
)(window.jQuery);
